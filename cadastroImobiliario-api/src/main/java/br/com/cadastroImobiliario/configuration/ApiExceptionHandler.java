package br.com.cadastroImobiliario.configuration;

import br.com.cadastroImobiliario.service.exception.NaoEncontradoException;
import br.com.cadastroImobiliario.service.exception.ServiceException;
import br.com.cadastroImobiliario.shared.dto.ErroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public List<ErroDTO> handleValidation(MethodArgumentNotValidException exception) {
        List<ErroDTO> dtos = new ArrayList<>();
        final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            ErroDTO erro = new ErroDTO(e.getField(), messageSource.getMessage(e, LocaleContextHolder.getLocale()));
            dtos.add(erro);
        });
        return dtos;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NaoEncontradoException.class})
    public ErroDTO handleNotFound(NaoEncontradoException ex) {
        return obterErro(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AuthenticationException.class})
    public ErroDTO handleAutenticacaoFalha(AuthenticationException ex) {
        return obterErro(ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ServiceException.class})
    public ErroDTO handleService(ServiceException ex) {
        return obterErro(ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, NullPointerException.class, RuntimeException.class})
    public ErroDTO handleGeral(Exception ex) {
        return obterErro(ex);
    }

    private ErroDTO obterErro(Exception ex) {
        return new ErroDTO()
                .campo(ex.getClass().getSimpleName())
                .erro(ex.getMessage());
    }
}
