package jp.co.htkk.framework.exception.type;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Throw ServiceException in Service layer
 */
@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1570238093095848448L;

    private final HttpStatus httpStatus;

    private final List<String> errorCodes;

    Map<String, Object> validationErrors = new LinkedHashMap<>();

    public ServiceException(HttpStatus httpStatus) {
        this(httpStatus, StringUtils.EMPTY, Collections.emptyList());
    }

    public ServiceException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.emptyList());
    }

    public ServiceException(HttpStatus httpStatus, String message, String errorCode) {
        this(httpStatus, message, Arrays.asList(errorCode));
    }

    public ServiceException(HttpStatus httpStatus, String message, List<String> errorCodes) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCodes = errorCodes;
    }

    public ServiceException(HttpStatus httpStatus, String message, List<String> errorCodes, Map<String, Object> validationErrors) {
        this(httpStatus, message, errorCodes);
        this.validationErrors = validationErrors;
    }
}
