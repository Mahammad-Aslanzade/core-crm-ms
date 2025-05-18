package az.company.corecrmms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnums {

    NOT_FOUND_EXCEPTION(DEFAULT_MESSAGES.NOT_FOUND, 1001, HttpStatus.NOT_FOUND),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(DEFAULT_MESSAGES.METHOD_ARGUMENT_NOT_VALID, 1002, HttpStatus.BAD_REQUEST),
    CONSTRAINT_VIOLATION_EXCEPTION(null, 1003, HttpStatus.BAD_REQUEST),
    ALREADY_EXIST_EXCEPTION(DEFAULT_MESSAGES.ALREADY_EXIST, 1004, HttpStatus.BAD_REQUEST)
    ;

    private final int exceptionCode;
    private final HttpStatus status;
    private final String defaultMessage;

    ExceptionEnums(String defaultMessage, int exceptionCode, HttpStatus status) {
        this.exceptionCode = exceptionCode;
        this.status = status;
        this.defaultMessage = defaultMessage;
    }

    private static class DEFAULT_MESSAGES {
        private final static String NOT_FOUND = "Object couldn't find with provided argument";
        public static final String METHOD_ARGUMENT_NOT_VALID = "Argument not valid";
        public static final String ALREADY_EXIST = "Argument is already exist";
    }
}
