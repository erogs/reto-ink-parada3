package pe.eickgs.ikf.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@Data
@AllArgsConstructor
public class ApiErrorsModel {

    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;
}
