package com.kp.knowledge.feigndemo.google.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DiscoveryDocument {
    String issuer;
    @JsonProperty("authorization_endpoint")
    String authorizationEndpoint;
    String token_endpoint;
    List<String> response_types_supported;
}
