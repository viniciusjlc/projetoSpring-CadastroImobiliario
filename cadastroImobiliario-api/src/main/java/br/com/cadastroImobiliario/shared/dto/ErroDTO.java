package br.com.cadastroImobiliario.shared.dto;

import java.io.Serializable;
import java.util.Objects;

public class ErroDTO implements Serializable {
    private String campo;
    private String erro;

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public ErroDTO campo(String campo) {
        this.campo = campo;
        return this;
    }

    public ErroDTO erro(String erro) {
        this.erro = erro;
        return this;
    }

    public ErroDTO() {
        super();
    }

    public ErroDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErroDTO erroDTO = (ErroDTO) o;
        return Objects.equals(campo, erroDTO.campo) &&
                Objects.equals(erro, erroDTO.erro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campo, erro);
    }


    @Override
    public String toString() {
        return "ErroDTO{" +
                "campo='" + campo + '\'' +
                ", erro='" + erro + '\'' +
                '}';
    }
}
