package orange.talents.rick.casadocodigo.model.builder;

import orange.talents.rick.casadocodigo.model.Autor;
import orange.talents.rick.casadocodigo.model.Categoria;
import orange.talents.rick.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroBuilder {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public static LivroBuilder getInstance(){
        return new LivroBuilder();
    }
    public LivroBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder resumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public LivroBuilder sumario(String sumario) {
        this.sumario = sumario;
        return this;
    }

    public LivroBuilder preco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public LivroBuilder numeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
        return this;
    }

    public LivroBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LivroBuilder dataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public LivroBuilder categoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public LivroBuilder autor(Autor autor) {
        this.autor = autor;
        return this;
    }

    public Livro build(){
        return new Livro(titulo, resumo, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
