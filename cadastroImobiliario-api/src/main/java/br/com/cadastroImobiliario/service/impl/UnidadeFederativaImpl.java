package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.service.UnidadeFederativaService;
import br.com.cadastroImobiliario.domain.UnidadeFederativa;
import br.com.cadastroImobiliario.repository.UnidadeFederativaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeFederativaImpl implements UnidadeFederativaService {
    private UnidadeFederativaRepository unidadeFederativaRepository;

    public UnidadeFederativaImpl(UnidadeFederativaRepository unidadeFederativaRepository) {
        this.unidadeFederativaRepository = unidadeFederativaRepository;
    }

    @Override
    public UnidadeFederativa consultarPorId(Long id) {
        return unidadeFederativaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nenhuma unidade federativa encontrada."));
    }

    @Override
    public List<UnidadeFederativa> listar() {
        return unidadeFederativaRepository.findAll();
    }
}
