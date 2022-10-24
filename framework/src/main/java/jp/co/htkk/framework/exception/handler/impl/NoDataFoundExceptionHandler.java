package jp.co.htkk.framework.exception.handler.impl;

import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.BasicErrorResponse;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.component.MessageService;
import jp.co.htkk.framework.exception.type.NoDataFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Handling No data found exception
 */
@Slf4j
public class NoDataFoundExceptionHandler implements IExceptionHandler<NoDataFoundException> {

    @Autowired
    private MessageService messageService;

    @Override
    public BasicErrorResponse handle(NoDataFoundException exception, HttpServletRequest req) {
        log.error(exception.getMessage(), exception);
        return ErrorResponse.of("No data found!", exception.getErrorCodes());
    }
}
