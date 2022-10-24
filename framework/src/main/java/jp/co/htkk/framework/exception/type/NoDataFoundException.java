package jp.co.htkk.framework.exception.type;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Throw ServiceException in Service layer
 */
@Data
public class NoDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 9051988811672873253L;

    private final List<String> errorCodes;

    public NoDataFoundException() {
        this(StringUtils.EMPTY, Collections.emptyList());
    }

    public NoDataFoundException(String message) {
        this(message, Collections.emptyList());
    }

    public NoDataFoundException(String message, String errorCode) {
        this(message, Arrays.asList(errorCode));
    }

    public NoDataFoundException(String message, List<String> errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
