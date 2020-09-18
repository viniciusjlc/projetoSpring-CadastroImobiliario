package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.domain.Documento;

import java.util.List;

public interface DocumentoService {

    Documento consultarPorId(Long id);

    List<Documento> listar();

}
