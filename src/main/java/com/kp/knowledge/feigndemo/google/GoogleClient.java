package com.kp.knowledge.feigndemo.google;

import com.kp.knowledge.feigndemo.google.model.DiscoveryDocument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "googleClient",
        url = "${feign.client.config.googleClient.url}",
        configuration = GoogleClientConfig.class
)
public interface GoogleClient {

    @GetMapping(value = "/.well-known/openid-configuration")
    DiscoveryDocument getDiscoveryDocument();

}
