package br.com.cadastroImobiliario.service.impl;

import br.com.cadastroImobiliario.domain.CadastroImobiliario;
import br.com.cadastroImobiliario.repository.CadastroImobiliarioRepository;
import br.com.cadastroImobiliario.service.CadastroImobiliarioService;
import br.com.cadastroImobiliario.service.TipoLogradouroService;
import br.com.cadastroImobiliario.service.UnidadeFederativaService;
import br.com.cadastroImobiliario.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroImobiliarioImpl implements CadastroImobiliarioService {
    private CadastroImobiliarioRepository cadastroImobiliarioRepository;
    private UnidadeFederativaService unidadeFederativaService;
    private TipoLogradouroService tipoLogradouroService;
    private UsuarioService usuarioService;

    public CadastroImobiliarioImpl(CadastroImobiliarioRepository cadastroImobiliarioRepository,
                                   UnidadeFederativaService unidadeFederativaService,
                                   TipoLogradouroService tipoLogradouroService,
                                   UsuarioService usuarioService) {
        this.cadastroImobiliarioRepository = cadastroImobiliarioRepository;
        this.unidadeFederativaService = unidadeFederativaService;
        this.tipoLogradouroService = tipoLogradouroService;
        this.usuarioService = usuarioService;
    }

    @Override
    public CadastroImobiliario consultarPorId(Long id) {
        return cadastroImobiliarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Nenhum cadastro imobiliario encontrado."));
    }

    @Override
    public List<CadastroImobiliario> listar() {
        return cadastroImobiliarioRepository.findAll();
    }

    @Override
    public CadastroImobiliario salvar(CadastroImobiliario cadastroImobiliario) {
        return cadastroImobiliarioRepository.save(new CadastroImobiliario(cadastroImobiliario,
                tipoLogradouroService.consultarPorId(cadastroImobiliario.getTipoLogradouro().getId()),
                unidadeFederativaService.consultarPorId(cadastroImobiliario.getUnidadeFederativa().getId()),
                usuarioService.consultarPorId(cadastroImobiliario.getUsuario().getId())));
    }

    @Override
    public CadastroImobiliario alterar(CadastroImobiliario cadastroImobiliario) {
        return this.salvar(cadastroImobiliario);
    }

    @Override
    public List<CadastroImobiliario> consultarPorUsuario(Long id) {
        return cadastroImobiliarioRepository.findByUsuarioId(id).orElseThrow(() -> new RuntimeException("Cadastros não encontrado."));
    }

    @Override
    public void excluir(Long id) {
        cadastroImobiliarioRepository.delete(consultarPorId(id));
    }
}
