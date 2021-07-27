package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.rest.validator.impl.EstaCadastradoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EstaCadastradoValidator.class)
public @interface EstaCadastrado {
    String message() default "Recurso nao encontrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    long value() default 1;

    Class<?> target();

    String field();
}
