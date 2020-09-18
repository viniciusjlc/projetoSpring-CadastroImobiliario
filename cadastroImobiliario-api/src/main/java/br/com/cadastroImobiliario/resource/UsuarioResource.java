package br.com.cadastroImobiliario.resource;

import br.com.cadastroImobiliario.service.UsuarioService;
import br.com.cadastroImobiliario.shared.form.CadastroUsuarioForm;
import br.com.cadastroImobiliario.domain.Usuario;
import br.com.cadastroImobiliario.shared.form.AutenticacaoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource {
    private UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.consultarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> listaUsuarios = usuarioService.listar();
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody CadastroUsuarioForm cadastroUsuarioForm) {
        Usuario usuarioSalvo = usuarioService.salvar(cadastroUsuarioForm);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @PostMapping(value = "/alterar")
    public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario) {
        Usuario usuarioAlterado = usuarioService.alterar(usuario);
        return ResponseEntity.ok(usuarioAlterado);
    }

    @PostMapping(value = "/consultarPorEmail")
    public ResponseEntity<Usuario> consultarPorEmail(@RequestBody AutenticacaoForm autenticacaoForm) {
        return ResponseEntity.ok(usuarioService.consultarPorEmail(autenticacaoForm.getEmail()));
    }
}
