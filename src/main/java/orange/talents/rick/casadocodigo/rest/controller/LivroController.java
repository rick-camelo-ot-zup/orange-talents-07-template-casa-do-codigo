package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.repository.AutorRepository;
import orange.talents.rick.casadocodigo.repository.CategoriaRepository;
import orange.talents.rick.casadocodigo.repository.LivroRepository;
import orange.talents.rick.casadocodigo.rest.dto.LivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
