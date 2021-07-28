package orange.talents.rick.casadocodigo.repository;

import orange.talents.rick.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Optional<Estado> findByNomeAndPaisId(String nome, Long id);
}
