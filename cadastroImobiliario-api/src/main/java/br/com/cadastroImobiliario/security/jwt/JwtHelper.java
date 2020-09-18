package br.com.cadastroImobiliario.security.jwt;

import br.com.cadastroImobiliario.configuration.AppProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtHelper {

    private final AppProperties appProperties;

    public JwtHelper(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String recuperarValorStringDoToken(String token, String chave) {
        return (String) obterClaims(token).get(chave);
    }

    public Integer recuperarValorInteiroDoToken(String token, String chave) {
        return (Integer) obterClaims(token).get(chave);
    }

    public SecretKey obterSecretKey() {
        return Keys.hmacShaKeyFor(obterBytesSegredoApp());
    }

    public Claims obterClaims(String token) {
        return Jwts.parser()
                .setSigningKey(obterSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public byte[] obterBytesSegredoApp() {
        String segredo = appProperties.getSeguranca().getAutenticacao().getJwt().getSegredo();
        return !StringUtils.isEmpty(segredo) ? obterBytesSegredo(segredo) : obterBytesSegredoBase64();
    }

    private byte[] obterBytesSegredo(String segredo) {
        return segredo.getBytes(StandardCharsets.UTF_8);
    }

    private byte[] obterBytesSegredoBase64() {
        return Decoders.BASE64.decode(appProperties.getSeguranca().getAutenticacao().getJwt().getSegredoBase64());
    }
}
