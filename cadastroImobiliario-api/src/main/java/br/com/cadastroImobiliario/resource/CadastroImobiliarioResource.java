package br.com.cadastroImobiliario.resource;

import br.com.cadastroImobiliario.domain.CadastroImobiliario;
import br.com.cadastroImobiliario.service.CadastroImobiliarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cadastroImobiliario")
public class CadastroImobiliarioResource {
    private CadastroImobiliarioService cadastroImobiliarioService;

    public CadastroImobiliarioResource(CadastroImobiliarioService cadastroImobiliarioService) {
        this.cadastroImobiliarioService = cadastroImobiliarioService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CadastroImobiliario> consultarPorId(@PathVariable Long id) {
        CadastroImobiliario cadastroImobiliario = cadastroImobiliarioService.consultarPorId(id);
        return ResponseEntity.ok(cadastroImobiliario);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<CadastroImobiliario>> listar() {
        List<CadastroImobiliario> listacadastrosImobiliarios = cadastroImobiliarioService.listar();
        return ResponseEntity.ok(listacadastrosImobiliarios);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<CadastroImobiliario> salvar(@RequestBody CadastroImobiliario cadastroImobiliario) {
        CadastroImobiliario cadastroImobiliarioSalvo = cadastroImobiliarioService.salvar(cadastroImobiliario);
        return ResponseEntity.ok(cadastroImobiliarioSalvo);
    }

    @PostMapping(value = "/alterar")
    public ResponseEntity<CadastroImobiliario> alterar(@RequestBody CadastroImobiliario cadastroImobiliario) {
        CadastroImobiliario cadastroImobiliarioAlterar = cadastroImobiliarioService.alterar(cadastroImobiliario);
        return ResponseEntity.ok(cadastroImobiliarioAlterar);
    }

    @GetMapping(value = "/listar/{idUsuario}")
    public ResponseEntity<List<CadastroImobiliario>> consultarPorUsuario(@PathVariable Long idUsuario) {
        List<CadastroImobiliario> listaCadastrosImobiliarios = cadastroImobiliarioService.consultarPorUsuario(idUsuario);
        return ResponseEntity.ok(listaCadastrosImobiliarios);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cadastroImobiliarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
