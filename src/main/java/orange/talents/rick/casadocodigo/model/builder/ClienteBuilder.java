package orange.talents.rick.casadocodigo.model.builder;

import orange.talents.rick.casadocodigo.model.Cliente;
import orange.talents.rick.casadocodigo.model.Estado;
import orange.talents.rick.casadocodigo.model.Pais;

public class ClienteBuilder {

    public static ClienteBuilder getInstance(){
        return new ClienteBuilder();
    }

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Pais pais;
    private Estado estado;
    private String telefone;
    private String cep;

    public ClienteBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public ClienteBuilder setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public ClienteBuilder setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public ClienteBuilder setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public ClienteBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public ClienteBuilder setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public ClienteBuilder setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public ClienteBuilder setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ClienteBuilder setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Cliente build(){
        return new Cliente(email,
                nome,
                sobrenome,
                documento,
                endereco,
                complemento,
                cidade,
                pais,
                telefone,
                cep);
    }
}
