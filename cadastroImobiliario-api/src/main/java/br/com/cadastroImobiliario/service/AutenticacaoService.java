package br.com.cadastroImobiliario.service;

import br.com.cadastroImobiliario.shared.dto.TokenDTO;
import br.com.cadastroImobiliario.shared.form.AutenticacaoForm;

public interface AutenticacaoService {

    TokenDTO autenticarUsuario(AutenticacaoForm autenticacaoForm);
}
