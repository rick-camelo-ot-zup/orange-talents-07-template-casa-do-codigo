package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.rest.validator.impl.CpfCnpjValidator;
import orange.talents.rick.casadocodigo.rest.validator.impl.EstaCadastradoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CpfCnpjValidator.class)
public @interface CpfCnpj {
    String message() default "O documento informado é inválido.";

    Class<?>[] groups() default { };

    String value() default "";

    Class<? extends Payload>[] payload() default { };
}
