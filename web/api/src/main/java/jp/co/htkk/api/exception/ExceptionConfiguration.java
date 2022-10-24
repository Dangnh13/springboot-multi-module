package jp.co.htkk.api.exception;

import jp.co.htkk.framework.exception.handler.impl.BindExceptionHandler;
import jp.co.htkk.framework.exception.handler.IExceptionHandler;
import jp.co.htkk.framework.exception.handler.impl.MethodArgumentNotValidExceptionHandler;
import jp.co.htkk.framework.exception.handler.impl.NoDataFoundExceptionHandler;
import jp.co.htkk.framework.exception.handler.impl.ServiceExceptionHandler;
import jp.co.htkk.framework.exception.handler.impl.UnknownExceptionHandler;
import jp.co.htkk.framework.exception.type.NoDataFoundException;
import jp.co.htkk.framework.exception.type.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Configuration
public class ExceptionConfiguration {
    @Bean
    public IExceptionHandler<ServiceException> serviceExceptionHandler() {
        return new ServiceExceptionHandler();
    }

    @Bean
    public IExceptionHandler<BindException> bindExceptionHandler() {
        return new BindExceptionHandler();
    }

    @Bean
    public IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler() {
        return new MethodArgumentNotValidExceptionHandler();
    }

    @Bean
    public IExceptionHandler<NoDataFoundException> noDataFoundExceptionIExceptionHandler() {
        return new NoDataFoundExceptionHandler();
    }

    @Bean
    public IExceptionHandler<Exception> unknownExceptionHandler() {
        return new UnknownExceptionHandler();
    }

}
