package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.model.Livro;
import orange.talents.rick.casadocodigo.repository.AutorRepository;
import orange.talents.rick.casadocodigo.repository.CategoriaRepository;
import orange.talents.rick.casadocodigo.repository.LivroRepository;
import orange.talents.rick.casadocodigo.rest.dto.DetalhesLivroSite;
import orange.talents.rick.casadocodigo.rest.dto.ItemListaLivro;
import orange.talents.rick.casadocodigo.rest.dto.LivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository repository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository repository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LivroRequest dto){
        repository.save(dto.toModel(autorRepository, categoriaRepository));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ItemListaLivro> getAll(){
        return repository.findAll().stream().map(ItemListaLivro::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()){
            DetalhesLivroSite detalhesLivroSite = new DetalhesLivroSite(livro.get());
            return ResponseEntity.ok().body(detalhesLivroSite);
        }
        return ResponseEntity.notFound().build();
    }
}
