package br.com.cadastroImobiliario.resource;

import br.com.cadastroImobiliario.domain.TipoLogradouro;
import br.com.cadastroImobiliario.service.TipoLogradouroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cadastroImobiliario/tipoLogradouro")
public class TipoLogradouroResource {

    private TipoLogradouroService tipoLogradouroService;

    public TipoLogradouroResource(TipoLogradouroService tipoLogradouroService) {
        this.tipoLogradouroService = tipoLogradouroService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoLogradouro> consultarPorId(@PathVariable Long id) {
        TipoLogradouro tipoLogradouro = tipoLogradouroService.consultarPorId(id);
        return ResponseEntity.ok(tipoLogradouro);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<TipoLogradouro>> listar() {
        List<TipoLogradouro> listaUnidadesFederativas = tipoLogradouroService.listar();
        return ResponseEntity.ok(listaUnidadesFederativas);
    }
}
