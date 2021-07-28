package orange.talents.rick.casadocodigo.repository;

import orange.talents.rick.casadocodigo.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
}
