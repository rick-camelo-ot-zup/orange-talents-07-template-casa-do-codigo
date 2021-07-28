package orange.talents.rick.casadocodigo.rest.controller;

import orange.talents.rick.casadocodigo.model.Cliente;
import orange.talents.rick.casadocodigo.repository.ClienteRepository;
import orange.talents.rick.casadocodigo.repository.EstadoRepository;
import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.dto.ClienteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;
    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public ClienteController(ClienteRepository repository, EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.repository = repository;
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ClienteRequest dto){
        Cliente cliente = repository.save(dto.toModel(estadoRepository, paisRepository));
        return ResponseEntity.ok(cliente.getId());
    }
}
