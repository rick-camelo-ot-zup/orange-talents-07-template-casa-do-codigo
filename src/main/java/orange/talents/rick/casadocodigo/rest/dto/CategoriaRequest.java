package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Categoria;
import orange.talents.rick.casadocodigo.rest.validator.NaoDuplicado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequest {

    @NotBlank
    @NotNull
    @NaoDuplicado(target = Categoria.class,
            field = "nome",
            message = "O nome já está cadastrado.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}
