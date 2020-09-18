package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.repository.DocumentoRepository;
import br.com.cadastroImobiliario.service.DocumentoService;
import br.com.cadastroImobiliario.domain.Documento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoImpl implements DocumentoService {
    private DocumentoRepository documentoRepository;

    public DocumentoImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public Documento consultarPorId(Long id) {
        return null;
    }

    @Override
    public List<Documento> listar() {
        return null;
    }
}
