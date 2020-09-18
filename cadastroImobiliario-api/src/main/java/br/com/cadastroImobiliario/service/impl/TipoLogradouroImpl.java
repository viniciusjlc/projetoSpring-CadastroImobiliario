package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.domain.TipoLogradouro;
import br.com.cadastroImobiliario.repository.TipoLogradouroRepository;
import br.com.cadastroImobiliario.service.TipoLogradouroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoLogradouroImpl implements TipoLogradouroService {
    private TipoLogradouroRepository tipoLogradouroRepository;

    public TipoLogradouroImpl(TipoLogradouroRepository tipoLogradouroRepository) {
        this.tipoLogradouroRepository = tipoLogradouroRepository;
    }

    @Override
    public TipoLogradouro consultarPorId(Long id) {
        return tipoLogradouroRepository.findById(id).orElseThrow(() -> new RuntimeException("Nenhum tipo logradouro encontrado."));
    }

    @Override
    public List<TipoLogradouro> listar() {
        return tipoLogradouroRepository.findAll();
    }
}
