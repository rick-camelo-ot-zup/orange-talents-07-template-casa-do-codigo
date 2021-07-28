package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Pais;
import orange.talents.rick.casadocodigo.rest.validator.NaoDuplicado;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @NaoDuplicado(
            target = Pais.class,
            field = "nome",
            message = "Este país já está cadastrado."
    )
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return new Pais(nome);
    }
}
