package jp.co.htkk.framework.exception.handler;

import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.exception.model.BasicErrorResponse;
import jp.co.htkk.framework.exception.model.ErrorCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Interface for system;s exceptions
 *
 * @param <T> which extends Exception
 */
public interface IExceptionHandler<T extends Exception> {

    Log log = LogFactory.getLog(IExceptionHandler.class);

    String VALIDATE_ERROR_MSG_KEY = "error.message.common.validation";

    String INTERNAL_SERVER_MSG_KEY = "error.message.common.server.internal";

    /**
     * Handle exception behavior
     *
     * @param exception which extends Exception
     * @return error response {@link ErrorResponse}
     */
    default BasicErrorResponse handle(T exception, HttpServletRequest req) {
        log.error(exception);
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                Arrays.asList(ErrorCode.EUNKNOWN.getErrorCode()));
    }

}