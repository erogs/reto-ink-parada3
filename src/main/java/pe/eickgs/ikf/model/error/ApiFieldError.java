package pe.eickgs.ikf.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Data
@AllArgsConstructor
public class ApiFieldError {

    private String field;
    private String code;
    private Object rejectedValue;
}
