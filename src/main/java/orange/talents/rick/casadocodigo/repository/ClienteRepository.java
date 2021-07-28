package orange.talents.rick.casadocodigo.repository;

import orange.talents.rick.casadocodigo.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
