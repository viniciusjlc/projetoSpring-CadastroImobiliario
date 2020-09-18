package br.com.cadastroImobiliario.resource;

import br.com.cadastroImobiliario.domain.UnidadeFederativa;
import br.com.cadastroImobiliario.service.UnidadeFederativaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cadastroImobiliario/unidadeFederativa")
public class UnidadeFederativaResource {
    private UnidadeFederativaService unidadeFederativaService;

    public UnidadeFederativaResource(UnidadeFederativaService unidadeFederativaService) {
        this.unidadeFederativaService = unidadeFederativaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeFederativa> consultarPorId(@PathVariable Long id) {
        UnidadeFederativa unidadeFederativa = unidadeFederativaService.consultarPorId(id);
        return ResponseEntity.ok(unidadeFederativa);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<UnidadeFederativa>> listar() {
        List<UnidadeFederativa> listaUnidadesFederativas = unidadeFederativaService.listar();
        return ResponseEntity.ok(listaUnidadesFederativas);
    }
}
