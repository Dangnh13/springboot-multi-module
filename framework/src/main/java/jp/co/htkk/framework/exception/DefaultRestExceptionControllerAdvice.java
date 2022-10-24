package jp.co.htkk.framework.exception;

import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.BasicErrorResponse;
import jp.co.htkk.framework.exception.model.ErrorCode;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.exception.type.NoDataFoundException;
import jp.co.htkk.framework.exception.type.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Handle exceptions across the whole application
 */
@Data
@AllArgsConstructor
@Slf4j
public class DefaultRestExceptionControllerAdvice {
    private final IExceptionHandler<ServiceException> serviceExceptionHandler;
    private final IExceptionHandler<BindException> bindExceptionHandler;
    private final IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler;
    private final IExceptionHandler<Exception> unknownExceptionHandler;
    private final IExceptionHandler<NoDataFoundException> noDataFoundExceptionIExceptionHandler;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> defaultErrorHandler(Exception e, HttpServletRequest req) {
        log.error("Unknown error", e);
        ErrorResponse errorResponse = (ErrorResponse) unknownExceptionHandler.handle(e, req);
        return new ResponseEntity<>(errorResponse,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex, HttpServletRequest req) {
        ErrorResponse errorResponse = (ErrorResponse) serviceExceptionHandler.handle(ex, req);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler({NoDataFoundException.class})
    public ResponseEntity<?> handleNoDataFoundException(NoDataFoundException ex, HttpServletRequest req) {
        BasicErrorResponse errorResponse = noDataFoundExceptionIExceptionHandler.handle(ex, req);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BindException.class,
    })
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex, HttpServletRequest req) {
        ErrorResponse errorResponse = (ErrorResponse) bindExceptionHandler.handle(ex, req);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, HttpServletRequest req) {
        ErrorResponse errorResponse = (ErrorResponse) methodArgumentNotValidExceptionIExceptionHandler.handle(ex, req);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResponseEntity<?> missingHeader(
            HttpServletRequest req, MissingRequestHeaderException e) {
        log.debug("Missing header {} - {} - ", e.getParameter(), e.getHeaderName(), e.getMessage());
        BasicErrorResponse errorResponse = ErrorResponse.of(ErrorCode.EMISSING_HEADER.getErrorMessage(),
                Arrays.asList(ErrorCode.EMISSING_HEADER.getErrorCode()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> methodNotSupportErrorHandler(
            HttpServletRequest req, Exception e) throws Exception {
        log.debug("MethodNotSupportedException error", e);
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED,
                "Method NotSupported",
                Arrays.asList(ErrorCode.EMETHODNOSUPPORT.getErrorCode()));
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(
            HttpServletRequest req, Exception e) {
        log.debug("HttpMessageNotReadableException error", e);
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST,
                ErrorCode.EMSGNOTREADABLE.getErrorMessage(),
                Arrays.asList(ErrorCode.EMSGNOTREADABLE.getErrorCode()));
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}

