package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.shared.form.CadastroUsuarioForm;
import br.com.cadastroImobiliario.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario salvar(CadastroUsuarioForm cadastroUsuarioForm);

    Usuario alterar(Usuario usuario);

    Usuario consultarPorId(Long id);

    Usuario consultarPorEmail(String email);

    List<Usuario> listar();

}
