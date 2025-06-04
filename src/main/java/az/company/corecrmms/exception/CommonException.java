package az.company.corecrmms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommonException extends RuntimeException {

    private final int exceptionCode;
    private final HttpStatus status;
    private final String message;
    private HashMap<String, String> params;

    public CommonException(ExceptionEnums exceptionEnum, String message, HashMap<String, String> params) {
        this.exceptionCode = exceptionEnum.getExceptionCode();
        this.status = exceptionEnum.getStatus();
        this.message = message;
        this.params = params;
    }

    public CommonException(ExceptionEnums exceptionEnum, String message) {
        this.exceptionCode = exceptionEnum.getExceptionCode();
        this.status = exceptionEnum.getStatus();
        this.message = message;
        this.params = null;
    }

    public CommonException(ExceptionEnums exceptionEnum) {
        this.exceptionCode = exceptionEnum.getExceptionCode();
        this.status = exceptionEnum.getStatus();
        this.message = exceptionEnum.getDefaultMessage();
    }

    public CommonException(ExceptionEnums exceptionEnum, HashMap<String, String> params) {
        this.exceptionCode = exceptionEnum.getExceptionCode();
        this.status = exceptionEnum.getStatus();
        this.message = exceptionEnum.getDefaultMessage();
        this.params = params;
    }
}
