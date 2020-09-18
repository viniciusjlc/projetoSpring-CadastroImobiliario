package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.domain.UnidadeFederativa;

import java.util.List;

public interface UnidadeFederativaService {

    UnidadeFederativa consultarPorId(Long id);

    List<UnidadeFederativa> listar();

}
