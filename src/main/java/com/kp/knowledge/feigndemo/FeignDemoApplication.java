package com.kp.knowledge.feigndemo;

import com.kp.knowledge.feigndemo.google.GoogleClient;
import com.kp.knowledge.feigndemo.google.model.DiscoveryDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignDemoApplication implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(FeignDemoApplication.class);

    @Autowired
    GoogleClient googleClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("About to initiate a call");

        final var discoveryDocument = googleClient.getDiscoveryDocument();

        log.info("discoveryDocument: {}", discoveryDocument);
    }
}
