package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.rest.validator.impl.EstadoUnicoParaPaisValidator;
import orange.talents.rick.casadocodigo.rest.validator.impl.ValidPaisEstadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPaisEstadoValidator.class)
public @interface ValidPaisEstado {
    String message() default "Recurso nao encontrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
