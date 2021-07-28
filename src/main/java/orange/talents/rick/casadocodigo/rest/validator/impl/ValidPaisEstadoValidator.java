package orange.talents.rick.casadocodigo.rest.validator.impl;

import orange.talents.rick.casadocodigo.model.Estado;
import orange.talents.rick.casadocodigo.model.Pais;
import orange.talents.rick.casadocodigo.repository.EstadoRepository;
import orange.talents.rick.casadocodigo.repository.PaisRepository;
import orange.talents.rick.casadocodigo.rest.dto.ClienteRequest;
import orange.talents.rick.casadocodigo.rest.validator.ValidPaisEstado;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class ValidPaisEstadoValidator implements ConstraintValidator<ValidPaisEstado, ClienteRequest> {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    private ConstraintValidatorContext contexto;
    private ClienteRequest cliente;

    @Override
    public void initialize(ValidPaisEstado constraintAnnotation) {
    }

    @Override
    public boolean isValid(ClienteRequest cliente, ConstraintValidatorContext constraintValidatorContext) {
        this.contexto = constraintValidatorContext;
        this.cliente = cliente;
        if(cliente.getPais() != null){
            Optional<Pais> possivelPais = paisRepository.findById(cliente.getPais());
            if(possivelPais.isPresent()){
                return validaPais(possivelPais.get());
            }else{
                return criaMensagem("País não encontrado.", "pais");
            }
        }
        return true;
    }

    public boolean validaPais(Pais pais){
        List<Estado> todosOsEstadosDoPais = estadoRepository.findAllByPaisId(pais.getId());
        if(todosOsEstadosDoPais.isEmpty()){
            if(this.cliente.getEstado() != null){
                criaMensagem("O país informado não tem estados cadastrados.", "estado");
            }
            return true;
        }
        return validaEstado(todosOsEstadosDoPais.get(0).getPais());
    }
    
    public boolean validaEstado(Pais pais){
        if(cliente.getEstado() == null){
            return criaMensagem("É necessario informar o estado", "estado");
        }
        Optional<Estado> possivelEstado = estadoRepository.findById(cliente.getEstado());
        if(possivelEstado.isEmpty()){
            return criaMensagem("Estado não encontrado.", "estado");
        }else{
            if(possivelEstado.get().getPais().getId() != pais.getId()){
                return criaMensagem("O estado não pertence ao pais.", "estado");
            }
        }
        return true;
    }

    public boolean criaMensagem(String mensagem, String campo){
        contexto.disableDefaultConstraintViolation();
        contexto.buildConstraintViolationWithTemplate(mensagem)
                .addPropertyNode(campo)
                .addConstraintViolation();
        return false;
    }
}
