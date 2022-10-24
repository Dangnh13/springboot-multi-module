package jp.co.htkk.framework.httpclient.google;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

public class AddQueryParameterInterceptor implements ClientHttpRequestInterceptor {

    private static final String KEY_PARAM = "key";

    private final String key;

    public AddQueryParameterInterceptor(String key) {
        this.key = key;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        URI uri = UriComponentsBuilder.fromHttpRequest(request)
                .queryParam(KEY_PARAM, this.key)
                .encode()
                .build()
                .toUri();

        HttpRequest modifiedRequest = new HttpRequestWrapper(request) {

            @Override
            public URI getURI() {
                return uri;
            }
        };
        return execution.execute(modifiedRequest, body);
    }

}