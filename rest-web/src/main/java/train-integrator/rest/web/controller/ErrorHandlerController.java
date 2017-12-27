package train-integrator.rest.web.controller;

import train-integrator.entity.constant.enums.ResponseCode;
import train-integrator.libraries.exception.BusinessLogicException;
import train-integrator.common.rest.web.model.response.BaseResponse;
import train-integrator.common.rest.web.model.response.CommonResponse;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestControllerAdvice
public class ErrorHandlerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerController.class);

  @ExceptionHandler(BindException.class)
  public BaseResponse bindException(BindException be) {
    LOGGER.info(be.toString());
    List<FieldError> bindErrors = be.getFieldErrors();
    List<String> errors = new ArrayList<>();
    for(FieldError fieldError : bindErrors) {
      errors.add(fieldError.getField() + " " + fieldError.getDefaultMessage());
    }

    return CommonResponse.constructResponse(ResponseCode.BIND_ERROR.getCode(), ResponseCode.BIND_ERROR.getMessage(),
        errors, null);
  }
  @ExceptionHandler(Exception.class)
  public BaseResponse exception(Exception e) {
    LOGGER.warn(e.toString());
    return CommonResponse.constructResponse(ResponseCode.SYSTEM_ERROR.getCode(), ResponseCode.SYSTEM_ERROR.getMessage(),
        null, null);
  }

  @ExceptionHandler(RuntimeException.class)
  public BaseResponse runTimeException(RuntimeException re) {
    LOGGER.warn(re.toString());
    return CommonResponse.constructResponse(ResponseCode.RUNTIME_ERROR.getCode(), ResponseCode.RUNTIME_ERROR.getMessage(),
        null, null);
  }

  @ExceptionHandler(BusinessLogicException.class)
  public BaseResponse businessLogicException(BusinessLogicException ble) {
    LOGGER.info(ble.toString());
    return CommonResponse.constructResponse(ble.getCode(), ble.getMessage(), null, null);
  }
}