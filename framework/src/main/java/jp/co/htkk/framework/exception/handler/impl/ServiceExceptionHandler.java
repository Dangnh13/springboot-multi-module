package jp.co.htkk.framework.exception.handler.impl;

import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.exception.type.ServiceException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Handling service exception
 */
@Slf4j
public class ServiceExceptionHandler implements IExceptionHandler<ServiceException> {

    @Override
    public ErrorResponse handle(ServiceException exception, HttpServletRequest req) {
        log.error(exception.getMessage(), exception);
        Map<String, Object> validationErrors = exception.getValidationErrors();
        return ErrorResponse.of(exception.getHttpStatus(), exception.getMessage(), exception.getErrorCodes(), validationErrors);
    }
}
