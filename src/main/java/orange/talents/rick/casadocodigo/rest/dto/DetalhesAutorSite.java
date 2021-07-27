package orange.talents.rick.casadocodigo.rest.dto;

public class DetalhesAutorSite {

    private String nome;
    private String descricao;

    public DetalhesAutorSite(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
