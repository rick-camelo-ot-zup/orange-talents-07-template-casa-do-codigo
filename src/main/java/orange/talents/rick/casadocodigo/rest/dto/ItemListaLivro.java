package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Livro;

public class ItemListaLivro {

    private Long id;
    private String titulo;

    public ItemListaLivro(Long id, String nome) {
        this.id = id;
        this.titulo = nome;
    }

    public static ItemListaLivro toDto(Livro livro){
        return new ItemListaLivro(livro.getId(), livro.getTitulo());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
