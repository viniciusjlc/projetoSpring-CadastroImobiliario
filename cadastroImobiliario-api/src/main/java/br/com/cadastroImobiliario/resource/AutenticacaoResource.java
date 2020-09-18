package br.com.cadastroImobiliario.resource;

import br.com.cadastroImobiliario.service.AutenticacaoService;
import br.com.cadastroImobiliario.shared.dto.TokenDTO;
import br.com.cadastroImobiliario.shared.form.AutenticacaoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AutenticacaoResource {

    private final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoResource.class);

    private AutenticacaoService autenticacaoService;

    public AutenticacaoResource(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/autenticar")
    public ResponseEntity<TokenDTO> autenticar(@Valid @RequestBody AutenticacaoForm autenticacaoForm) {
        LOGGER.debug("Requisição REST para autenticar com a api: {}", autenticacaoForm);
        TokenDTO tokenDTO = autenticacaoService.autenticarUsuario(autenticacaoForm);
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
    }
}
