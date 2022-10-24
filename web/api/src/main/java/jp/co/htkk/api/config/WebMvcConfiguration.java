package jp.co.htkk.api.config;

import jp.co.htkk.api.interceptor.AuthorizationInterceptor;
import jp.co.htkk.framework.component.MessageService;
import jp.co.htkk.framework.constant.CommonConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {


    // =========================================================================
    //                                                                Constant
    //                                                                ==========

    // =========================================================================
    //                                                                DI
    //                                                                ==========

    private final AuthorizationInterceptor authorizationInterceptor;

    @Bean
    public MessageService messageService(final MessageSource messageSource) {
        return new MessageService(messageSource, Locale.JAPANESE);
    }

    // =========================================================================
    //                                                                Public method
    //                                                                ==========

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns(CommonConstant.PATH_PATTERNS.ALL)
                .excludePathPatterns(CommonConstant.PATH_PATTERNS.SWAGGER)
                .excludePathPatterns(CommonConstant.PATH_PATTERNS.HEALTH);
    }



}
