package jp.co.htkk.framework.httpclient.google;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GoogleClientRestTemplateCustomizer implements RestTemplateCustomizer {

    private final String key;

    public GoogleClientRestTemplateCustomizer(String key) {
        this.key = key;
    }

    @Override
    public void customize(RestTemplate restTemplate) {

        restTemplate.getInterceptors()
                .addAll(
                        Arrays.asList(
                                new AddQueryParameterInterceptor(this.key),
                                new LoggingRequestInterceptor()
                        )
                );
    }

}