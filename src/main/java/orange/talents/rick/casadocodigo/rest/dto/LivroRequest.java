package orange.talents.rick.casadocodigo.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import orange.talents.rick.casadocodigo.model.Autor;
import orange.talents.rick.casadocodigo.model.Categoria;
import orange.talents.rick.casadocodigo.model.Livro;
import orange.talents.rick.casadocodigo.model.builder.LivroBuilder;
import orange.talents.rick.casadocodigo.repository.AutorRepository;
import orange.talents.rick.casadocodigo.repository.CategoriaRepository;
import orange.talents.rick.casadocodigo.rest.validator.EstaCadastrado;
import orange.talents.rick.casadocodigo.rest.validator.NaoDuplicado;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @NotNull
    @NaoDuplicado(
            target = Livro.class,
            field = "titulo",
            message = "Esse título já está cadastrado."
    )
    private String titulo;
    @NotBlank
    @NotNull
    @Length(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotNull
    @NotBlank
    @NaoDuplicado(
            target = Livro.class,
            field = "isbn",
            message = "Esse isbn já está cadastrado."
    )
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate dataPublicacao;
    @EstaCadastrado(
            target = Categoria.class,
            field = "id",
            message = "Categoria não encontrado;"
    )
    private long categoria;
    @EstaCadastrado(
            target = Autor.class,
            field = "id",
            message = "Autor não encontrado;"
    )
    private long autor;

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
        Autor autor = autorRepository.getOne(this.autor);
        Categoria categoria = categoriaRepository.getOne(this.categoria);

        return LivroBuilder.getInstance()
                .titulo(titulo)
                .resumo(resumo)
                .preco(preco)
                .numeroPaginas(numeroPaginas)
                .isbn(isbn)
                .dataPublicacao(dataPublicacao)
                .categoria(categoria)
                .autor(autor)
                .build();
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

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }
}
