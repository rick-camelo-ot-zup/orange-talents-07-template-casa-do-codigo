package orange.talents.rick.casadocodigo.rest.validator.impl;

import orange.talents.rick.casadocodigo.rest.validator.NaoDuplicado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NaoDuplicadoValidator implements ConstraintValidator<NaoDuplicado, String> {

    private Class<?> entidade;
    private String campo;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(NaoDuplicado constraintAnnotation) {
        this.entidade = constraintAnnotation.target();
        this.campo = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String query = "SELECT c FROM "+entidade.getName()+" c WHERE c."+campo+" = '"+value+"'";

        List lista = em.createQuery(query).getResultList();

        return lista.isEmpty();
    }
}