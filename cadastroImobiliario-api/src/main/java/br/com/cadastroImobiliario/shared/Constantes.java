package br.com.cadastroImobiliario.shared;

public interface Constantes {

    interface Jwt {
        String CHAVE_ID_USUARIO = "id_usuario";
        String CHAVE_EMAIL_USUARIO = "email_usuario";
        String CHAVE_PERMISSOES = "permissoes";
    }

    interface Permissoes {
        String ADMIN = "ROLE_ADMIN";
        String USER = "ROLE_USER";
        String ANONYMOUS = "ROLE_ANONYMOUS";
        String GERAL = "ROLE_GERAL";
    }
}
