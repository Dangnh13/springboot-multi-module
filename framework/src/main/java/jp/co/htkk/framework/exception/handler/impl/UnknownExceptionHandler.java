package jp.co.htkk.framework.exception.handler.impl;

import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.BasicErrorResponse;
import jp.co.htkk.framework.exception.model.ErrorCode;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.component.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Handling service exception
 */
@Slf4j
public class UnknownExceptionHandler implements IExceptionHandler<Exception> {

    @Autowired
    private MessageService messageService;

    @Override
    public BasicErrorResponse handle(Exception exception, HttpServletRequest req) {
        log.error(exception.getMessage());
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                messageService.getMessage(INTERNAL_SERVER_MSG_KEY, req),
                Arrays.asList(ErrorCode.EUNKNOWN.getErrorCode()));
    }
}
