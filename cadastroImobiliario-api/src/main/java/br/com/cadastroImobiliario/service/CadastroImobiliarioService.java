package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.domain.CadastroImobiliario;

import java.util.List;

public interface CadastroImobiliarioService {

    CadastroImobiliario consultarPorId(Long id);

    List<CadastroImobiliario> listar();

    CadastroImobiliario salvar(CadastroImobiliario cadastroImobiliario);

    CadastroImobiliario alterar(CadastroImobiliario cadastroImobiliario);

    List<CadastroImobiliario> consultarPorUsuario(Long id);

    void excluir(Long id);
}
