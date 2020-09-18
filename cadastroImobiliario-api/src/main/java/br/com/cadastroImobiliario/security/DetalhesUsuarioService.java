package br.com.cadastroImobiliario.security;

import br.com.cadastroImobiliario.domain.Usuario;
import br.com.cadastroImobiliario.repository.UsuarioRepository;
import br.com.cadastroImobiliario.shared.Constantes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class DetalhesUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public DetalhesUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email ou senha invalido."));
        return retornarDetalhesUsuario(usuario);
    }

    private UserDetails retornarDetalhesUsuario(Usuario usuario) {
        return new UsuarioSistema(usuario, obterPermissoes());
    }

    private Collection<? extends GrantedAuthority> obterPermissoes() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(Constantes.Permissoes.GERAL));
        return authorities;
    }
}
