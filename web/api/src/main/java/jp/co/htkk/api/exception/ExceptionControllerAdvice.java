package jp.co.htkk.api.exception;

import jp.co.htkk.framework.exception.DefaultRestExceptionControllerAdvice;
import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.type.NoDataFoundException;
import jp.co.htkk.framework.exception.type.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerAdvice extends DefaultRestExceptionControllerAdvice {

    public ExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                     IExceptionHandler<BindException> bindExceptionHandler,
                                     IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler,
                                     IExceptionHandler<Exception> unknownExceptionHandler,
                                     IExceptionHandler<NoDataFoundException> noDataFoundExceptionIExceptionHandler) {
        super(serviceExceptionHandler,
                bindExceptionHandler,
                methodArgumentNotValidExceptionIExceptionHandler,
                unknownExceptionHandler,
                noDataFoundExceptionIExceptionHandler);
    }
}
