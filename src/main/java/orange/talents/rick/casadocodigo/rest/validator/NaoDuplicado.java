package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.rest.validator.impl.NaoDuplicadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NaoDuplicadoValidator.class)
public @interface NaoDuplicado {

    String message() default "Valor já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

    Class<?> target();

    String field();
}