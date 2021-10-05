package com.kp.knowledge.feigndemo.google;

import feign.*;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
import org.springframework.cloud.openfeign.security.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleClientConfig {

//    @Bean
//    public Logger.Level loggerLevel() {
//        return Logger.Level.FULL;
//    }

//    below does not work either with Collection<RequestInterceptor>
//    @Bean
//    public Iterable<RequestInterceptor> requestInterceptors() {
//        return List.of(
////                new MyRequestInterceptor(),
//                basicAuthRequestInterceptor()
//        );
//    }

    @Bean
    public Request.Options client() {
        return new Request.Options(
                30, TimeUnit.SECONDS,
                60, TimeUnit.SECONDS,
                true
        );
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("dummy-user", "dummy-password");
    }

    @Bean
    public MyRequestInterceptor myRequestInterceptor() {
        return new MyRequestInterceptor();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(5, 10, 3);
    }

    static class MyRequestInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            template.header(
                    "X-My-Custom-Header",
                    List.of("Value1", "Value2")
            );
        }
    }

}
