package pe.eickgs.ikf.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.eickgs.ikf.model.client.ClientInputDto;
import pe.eickgs.ikf.utils.Constants;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
public class ClientValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ClientInputDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientInputDto dto = (ClientInputDto) target;
        int realAge = Period.between(dto.getBirthdate(), LocalDate.now()).getYears();
        if (realAge != dto.getAge()) {
            errors.reject(Constants.AGE_ERROR);
        }
    }
}
