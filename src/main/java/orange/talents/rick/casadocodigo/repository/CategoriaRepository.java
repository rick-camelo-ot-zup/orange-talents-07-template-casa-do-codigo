package orange.talents.rick.casadocodigo.repository;

import orange.talents.rick.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
