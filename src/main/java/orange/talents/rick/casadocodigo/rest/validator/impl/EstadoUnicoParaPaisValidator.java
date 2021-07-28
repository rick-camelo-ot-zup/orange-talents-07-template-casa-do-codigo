package orange.talents.rick.casadocodigo.rest.validator.impl;

import orange.talents.rick.casadocodigo.model.Estado;
import orange.talents.rick.casadocodigo.repository.EstadoRepository;
import orange.talents.rick.casadocodigo.rest.dto.EstadoRequest;
import orange.talents.rick.casadocodigo.rest.validator.EstadoUnicoParaPais;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EstadoUnicoParaPaisValidator implements ConstraintValidator<EstadoUnicoParaPais, EstadoRequest> {

    @Autowired
    private EstadoRepository repository;

    @Override
    public void initialize(EstadoUnicoParaPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoRequest estado, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Estado> possivelEstado = repository.findByNomeAndPaisId(estado.getNome(), estado.getPais());
        if(possivelEstado.isEmpty()){
            return true;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(
                "Este "+estado.getNome()+" já está cadastrado para o país "
                        +possivelEstado.get().getPais().getNome()+"")
                .addPropertyNode("nome")
                .addConstraintViolation();
        return false;
    }
}
