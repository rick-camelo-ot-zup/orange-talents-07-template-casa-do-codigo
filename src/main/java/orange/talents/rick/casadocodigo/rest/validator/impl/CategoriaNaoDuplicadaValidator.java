package orange.talents.rick.casadocodigo.rest.validator.impl;

import orange.talents.rick.casadocodigo.model.Categoria;
import orange.talents.rick.casadocodigo.repository.CategoriaRepository;
import orange.talents.rick.casadocodigo.rest.validator.CategoriaNaoDuplicada;
import orange.talents.rick.casadocodigo.rest.validator.EmailNaoDuplicado;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CategoriaNaoDuplicadaValidator implements ConstraintValidator<CategoriaNaoDuplicada, String> {

    private String value;
    @Autowired
    private CategoriaRepository repository;

    @Override
    public void initialize(CategoriaNaoDuplicada constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Categoria> categoria = repository.findByNome(value);

        if (categoria.isPresent()) {
            return false;
        }
        return true;
    }
}
