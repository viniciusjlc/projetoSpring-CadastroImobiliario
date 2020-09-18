package br.com.cadastroImobiliario.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cadastro_imobiliario", schema = "imobiliario")
public class CadastroImobiliario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadastroImobiliarioSequenceGenerator")
    @SequenceGenerator(name = "cadastroImobiliarioSequenceGenerator", sequenceName = "cadastro_imobiliario_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @OneToOne
    @JoinColumn(name = "id_tipo_logradouro")
    private TipoLogradouro tipoLogradouro;

    @OneToOne
    @JoinColumn(name = "id_unidade_federativa")
    private UnidadeFederativa unidadeFederativa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CadastroImobiliario() {
    }

    public CadastroImobiliario(CadastroImobiliario cadastroImobiliario,
                               TipoLogradouro tipoLogradouro,
                               UnidadeFederativa unidadeFederativa,
                               Usuario usuario) {
        this.id = cadastroImobiliario.id;
        this.cep = cadastroImobiliario.cep;
        this.endereco = cadastroImobiliario.endereco;
        this.complemento = cadastroImobiliario.complemento;
        this.numero = cadastroImobiliario.numero;
        this.bairro = cadastroImobiliario.bairro;
        this.cidade = cadastroImobiliario.cidade;
        this.tipoLogradouro = tipoLogradouro;
        this.unidadeFederativa = unidadeFederativa;
        this.usuario = usuario;
    }
}
