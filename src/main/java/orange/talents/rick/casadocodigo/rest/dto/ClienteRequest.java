package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Cliente;
import orange.talents.rick.casadocodigo.model.Estado;
import orange.talents.rick.casadocodigo.model.Pais;
import orange.talents.rick.casadocodigo.model.builder.ClienteBuilder;
import orange.talents.rick.casadocodigo.repository.EstadoRepository;
import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.validator.CpfCnpj;
import orange.talents.rick.casadocodigo.rest.validator.NaoDuplicado;
import orange.talents.rick.casadocodigo.rest.validator.ValidPaisEstado;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@ValidPaisEstado
public class ClienteRequest {
    @Email
    @NotBlank
    @NaoDuplicado(
            target = Cliente.class,
            field = "email",
            message = "Este email já está cadastrado."
    )
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @NaoDuplicado(
            target = Cliente.class,
            field = "documento",
            message = "Este documento já está cadastrado."
    )
    @CpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long pais;
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository){
        Optional<Pais> pais = paisRepository.findById(this.pais);
        Cliente cliente = ClienteBuilder.getInstance()
                .setEmail(email)
                .setNome(nome)
                .setCep(cep)
                .setCidade(cidade)
                .setComplemento(complemento)
                .setDocumento(documento)
                .setEndereco(endereco)
                .setPais(pais.get())
                .setSobrenome(sobrenome)
                .setTelefone(telefone)
                .build();

        if(this.estado != null){
            Optional<Estado> estado = estadoRepository.findById(this.estado);
            cliente.setEstado(estado.get());
        }
        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
