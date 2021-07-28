package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Estado;
import orange.talents.rick.casadocodigo.model.Pais;
import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.validator.EstaCadastrado;
import orange.talents.rick.casadocodigo.rest.validator.EstadoUnicoParaPais;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@EstadoUnicoParaPais
public class EstadoRequest {

    @NotBlank
    private String nome;
    @EstaCadastrado(
            target = Pais.class,
            field = "id",
            message = "Pais não encontrado"
    )
    private Long pais;

    public EstadoRequest(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado toModel(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.pais);
        return new Estado(nome, pais.get());
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }
}
