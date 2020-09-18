package br.com.cadastroImobiliario.service.exception;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException(String message) {
        super(message);
    }
}
