package org.os.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author yzm
 * @date 2021/1/28 2:29 下午
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpHeaders httpHeaders = httpRequest.getHeaders();
//        httpHeaders.add("serialId",);

        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
