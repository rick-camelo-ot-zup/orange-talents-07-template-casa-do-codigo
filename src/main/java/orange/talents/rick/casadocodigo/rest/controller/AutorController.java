package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.repository.AutorRepository;
import orange.talents.rick.casadocodigo.rest.dto.AutorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AutorRequest dto){
        repository.save(dto.toModel());
        return ResponseEntity.status(200).build();
    }
}
