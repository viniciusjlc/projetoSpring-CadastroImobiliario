package br.com.cadastroImobiliario.security.jwt;

import br.com.cadastroImobiliario.security.UsuarioSistema;
import br.com.cadastroImobiliario.configuration.AppProperties;
import br.com.cadastroImobiliario.shared.Constantes;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private final AppProperties appProperties;
    private final JwtHelper jwtHelper;

    private long validadeTokenEmMilissegundos;
    private long validadeTokenEmMilissegundosComLembrar;

    public TokenProvider(AppProperties appProperties, JwtHelper jwtHelper) {
        this.appProperties = appProperties;
        this.jwtHelper = jwtHelper;
    }

    @PostConstruct
    public void init() {
        this.validadeTokenEmMilissegundos = 1000 * appProperties.getSeguranca().getAutenticacao().getJwt().getValidadeTokenEmMilissegundos();
        this.validadeTokenEmMilissegundosComLembrar = 1000 * appProperties.getSeguranca().getAutenticacao().getJwt().getValidadeTokenEmMilissegundosComLembrar();
    }

    public String criarToken(Authentication authentication, boolean lembrar) {
        return Jwts.builder()
                .setClaims(obterInformacoesToken(authentication))
                .signWith(jwtHelper.obterSecretKey(), SignatureAlgorithm.HS512)
                .setExpiration(obterTempoExpiracaoToken(lembrar))
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            jwtHelper.obterClaims(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Assinatura do JWT inválida.");
            log.trace("Assinatura do JWT inválida trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Token expirado.");
            log.trace("Token expirado trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Token não suportado.");
            log.trace("Token não suportado trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("Compactação do token inválida.");
            log.trace("Compactação do token inválida trace: {}", e);
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = jwtHelper.obterClaims(token);
        Collection<? extends GrantedAuthority> authorities = obterPermissoesToken(claims);
        User principal = new User(claims.get(Constantes.Jwt.CHAVE_EMAIL_USUARIO).toString(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    private Map<String, Object> obterInformacoesToken(Authentication authentication) {
        UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constantes.Jwt.CHAVE_ID_USUARIO, usuarioSistema.getUsuario().getId());
        claims.put(Constantes.Jwt.CHAVE_EMAIL_USUARIO, usuarioSistema.getUsername());
        claims.put(Constantes.Jwt.CHAVE_PERMISSOES, retornarPermissoesComcatenadas(authentication));
        return claims;
    }

    private String retornarPermissoesComcatenadas(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    private Date obterTempoExpiracaoToken(boolean manterConectado) {
        long agora = (new Date()).getTime();
        return manterConectado ? new Date(agora + this.validadeTokenEmMilissegundosComLembrar) : new Date(agora + this.validadeTokenEmMilissegundos);
    }

    private List<SimpleGrantedAuthority> obterPermissoesToken(Claims claims) {
        return Arrays.stream(claims.get(Constantes.Jwt.CHAVE_PERMISSOES).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
