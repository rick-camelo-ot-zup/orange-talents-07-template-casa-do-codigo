package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.rest.validator.impl.EstadoUnicoParaPaisValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoUnicoParaPaisValidator.class)
public @interface EstadoUnicoParaPais {
    String message() default "Este Estado já está cadastrado para este país.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
