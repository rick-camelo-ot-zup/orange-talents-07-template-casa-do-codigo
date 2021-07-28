package orange.talents.rick.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank
    @Column(nullable = false)
    private String sobrenome;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String documento;
    @NotBlank
    @Column(nullable = false)
    private String endereco;
    @NotBlank
    @Column(nullable = false)
    private String complemento;
    @NotBlank
    @Column(nullable = false)
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    @Column(nullable = false)
    private String telefone;
    @NotBlank
    @Column(nullable = false)
    private String cep;

    @Deprecated
    public Cliente() {
    }

    public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                   @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
                   @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais.getNome() +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
