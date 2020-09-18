package br.com.cadastroImobiliario.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documentos_cadastro_imobiliario", schema = "imobiliario")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentosSequenceGenerator")
    @SequenceGenerator(name = "documentosSequenceGenerator", sequenceName = "documentos_cadastro_imobiliario_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "extensao")
    private String extensao;

    @Column(name = "documento")
    private byte[] documento;

    @ManyToOne
    @JoinColumn(name = "id_cadastro_imobiliario")
    private CadastroImobiliario cadastroImobiliario;

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public CadastroImobiliario getCadastroImobiliario() {
        return cadastroImobiliario;
    }

    public void setCadastroImobiliario(CadastroImobiliario cadastroImobiliario) {
        this.cadastroImobiliario = cadastroImobiliario;
    }
}
