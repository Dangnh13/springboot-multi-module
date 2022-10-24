package jp.co.htkk.framework.exception.handler.impl;

import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.model.ErrorCode;
import jp.co.htkk.framework.exception.model.ErrorResponse;
import jp.co.htkk.framework.component.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Handling of BindException
 */
@Slf4j
public class BindExceptionHandler implements IExceptionHandler<BindException> {

    @Autowired
    private MessageService messageService;

    @Override
    public ErrorResponse handle(BindException exception, HttpServletRequest req) {
        log.error(exception.getMessage(), exception);
        Map<String, Object> validationErrors = new LinkedHashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    Object rejectValue = !(error.getRejectedValue() instanceof MultipartFile) ? error.getRejectedValue() : StringUtils.EMPTY;
                    String errorMessage = (StringUtils.isNotEmpty(error.getDefaultMessage()) ? error.getDefaultMessage() : messageService.getMessage(error.getCode(), req, error.getArguments()));
                    validationErrors.put(error.getField(), new ErrorResponse.ItemError(rejectValue, errorMessage));
                });

        return ErrorResponse.of(HttpStatus.BAD_REQUEST,
                messageService.getMessage(VALIDATE_ERROR_MSG_KEY, req),
                Arrays.asList(ErrorCode.EINVAL.getErrorCode()), validationErrors);
    }

}
