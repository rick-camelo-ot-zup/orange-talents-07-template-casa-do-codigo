package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.dto.PaisRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private PaisRepository repository;

    public PaisController(PaisRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PaisRequest dto){
        repository.save(dto.toModel());
        return ResponseEntity.ok().build();

    }
}
