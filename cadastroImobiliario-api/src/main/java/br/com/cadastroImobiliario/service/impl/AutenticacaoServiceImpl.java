package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.security.jwt.TokenProvider;
import br.com.cadastroImobiliario.service.AutenticacaoService;
import br.com.cadastroImobiliario.shared.dto.TokenDTO;
import br.com.cadastroImobiliario.shared.form.AutenticacaoForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoServiceImpl(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenDTO autenticarUsuario(AutenticacaoForm autenticacaoForm) {
        Authentication authentication = autenticar(autenticacaoForm);
        String token = tokenProvider.criarToken(authentication, false);
        return new TokenDTO(token);
    }

    private Authentication autenticar(AutenticacaoForm autenticacaoForm) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoForm.getEmail(), autenticacaoForm.getSenha());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
}
