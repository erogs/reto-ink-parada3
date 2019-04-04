package pe.eickgs.ikf.api.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pe.eickgs.ikf.model.error.ApiErrorsModel;
import pe.eickgs.ikf.model.error.ApiFieldError;
import pe.eickgs.ikf.model.error.ApiGlobalError;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Erick GS
 * @version 2019-04-02
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException notValidException,
                                                                  HttpHeaders headers,  HttpStatus status, WebRequest request) {
        BindingResult bindingResult = notValidException.getBindingResult();

        List<ApiFieldError> apiFieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ApiFieldError(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getRejectedValue())
                ).collect(toList());

        List<ApiGlobalError> apiGlobalErrors = bindingResult
                .getGlobalErrors()
                .stream()
                .map(globalError -> new ApiGlobalError(
                        globalError.getCode())
                ).collect(toList());

        ApiErrorsModel apiErrorsModel = new ApiErrorsModel(apiFieldErrors, apiGlobalErrors);

        return new ResponseEntity<>(apiErrorsModel, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
