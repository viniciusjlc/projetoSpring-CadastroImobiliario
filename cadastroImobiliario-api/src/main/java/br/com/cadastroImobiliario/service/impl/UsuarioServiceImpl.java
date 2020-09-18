package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.service.UsuarioService;
import br.com.cadastroImobiliario.shared.form.CadastroUsuarioForm;
import br.com.cadastroImobiliario.domain.Usuario;
import br.com.cadastroImobiliario.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvar(CadastroUsuarioForm cadastroUsuarioForm) {
        return usuarioRepository.save(new Usuario().toEntity(cadastroUsuarioForm, passwordEncoder.encode(cadastroUsuarioForm.getSenha())));
    }

    @Override
    public Usuario alterar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario consultarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum usuario encontrado."));
    }

    @Override
    public Usuario consultarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Nenhum usuario encontrado."));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
