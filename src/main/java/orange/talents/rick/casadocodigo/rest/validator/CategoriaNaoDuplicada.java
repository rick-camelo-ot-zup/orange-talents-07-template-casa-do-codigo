package orange.talents.rick.casadocodigo.rest.validator;


import orange.talents.rick.casadocodigo.rest.validator.impl.CategoriaNaoDuplicadaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CategoriaNaoDuplicadaValidator.class)
public @interface CategoriaNaoDuplicada {

    String message() default "A categoria informada já está cadastrada";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}