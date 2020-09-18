package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.domain.TipoLogradouro;

import java.util.List;

public interface TipoLogradouroService {

    TipoLogradouro consultarPorId(Long id);

    List<TipoLogradouro> listar();

}
