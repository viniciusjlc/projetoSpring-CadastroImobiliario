package br.com.cadastroImobiliario.domain;

import br.com.cadastroImobiliario.shared.form.CadastroUsuarioForm;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

@DynamicInsert
@Entity
@Table(schema = "imobiliario", name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuariosSequenceGenerator")
    @SequenceGenerator(name = "usuariosSequenceGenerator", schema = "imobiliario", sequenceName = "usuarios_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toEntity(CadastroUsuarioForm cadastroUsuarioForm, String senhaCriptografada) {
        this.nome = cadastroUsuarioForm.getNome();
        this.email = cadastroUsuarioForm.getEmail();
        this.senha = senhaCriptografada;
        return this;
    }
}
