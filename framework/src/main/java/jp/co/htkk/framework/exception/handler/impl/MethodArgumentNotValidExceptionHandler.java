package jp.co.htkk.framework.exception.handler.impl;

import jp.co.htkk.framework.component.MessageService;
import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.ErrorCode;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Handling of BindException
 */
@Slf4j
public class MethodArgumentNotValidExceptionHandler implements IExceptionHandler<MethodArgumentNotValidException> {

    @Autowired
    private MessageService messageService;

    @Override
    public ErrorResponse handle(MethodArgumentNotValidException exception, HttpServletRequest req) {
        log.error(exception.getMessage(), exception);
        Map<String, Object> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    Object rejectValue = !(error.getRejectedValue() instanceof MultipartFile) ? error.getRejectedValue() : StringUtils.EMPTY;
                    validationErrors.put(error.getField(), new ErrorResponse.ItemError(rejectValue, error.getDefaultMessage()));
                });

        return ErrorResponse.of(HttpStatus.BAD_REQUEST,
                messageService.getMessage(VALIDATE_ERROR_MSG_KEY, req),
                Arrays.asList(ErrorCode.EINVAL.getErrorCode()), validationErrors);
    }

}
