package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.repository.EstadoRepository;
import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.dto.EstadoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository repository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository repository, PaisRepository paisRepository, Validator validator) {
        this.repository = repository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid EstadoRequest dto){
        repository.save(dto.toModel(this.paisRepository));
        return ResponseEntity.ok().build();
    }
}

