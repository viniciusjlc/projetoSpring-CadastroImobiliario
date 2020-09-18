package br.com.cadastroImobiliario.util;

import br.com.cadastroImobiliario.service.exception.ServiceException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {
    public SecurityUtil() {
    }

    public static String obterLoginUsuarioLogado() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> ((UserDetails) authentication.getPrincipal()).getUsername())
                .orElseThrow(() -> new ServiceException("Erro ao obter dados do usuário."));
    }
}
