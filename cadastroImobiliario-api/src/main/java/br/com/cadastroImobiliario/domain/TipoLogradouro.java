package br.com.cadastroImobiliario.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tipo_logradouro", schema = "imobiliario")
public class TipoLogradouro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoLogradouroSequenceGenerator")
    @SequenceGenerator(name = "tipoLogradouroSequenceGenerator",  schema = "imobiliario", sequenceName = "tipo_logradouro_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoLogradouro that = (TipoLogradouro) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    @Override
    public String toString() {
        return "TipoLogradouro{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
