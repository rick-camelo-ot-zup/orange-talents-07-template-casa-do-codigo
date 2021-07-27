package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroSite {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private String dataPublicacao;
    private DetalhesAutorSite autor;
    private String categoria;

    public DetalhesLivroSite(Livro livro) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        dataPublicacao = livro.getDataPublicacao().format(formatoData);
        autor = new DetalhesAutorSite(livro.getAutor().getNome(),livro.getAutor().getDescricao());
        categoria = livro.getCategoria().getNome();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalhesAutorSite getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }
}
