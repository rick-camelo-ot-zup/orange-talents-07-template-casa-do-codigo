package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.repository.CategoriaRepository;
import orange.talents.rick.casadocodigo.rest.dto.CategoriaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CategoriaRequest dto){
        repository.save(dto.toModel());
        return ResponseEntity.status(200).build();
    }
}
