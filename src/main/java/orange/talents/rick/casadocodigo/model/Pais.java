package orange.talents.rick.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {
    }

    public String getNome() {
        return nome;
    }
}
