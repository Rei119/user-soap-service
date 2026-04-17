package com.soap;

import jakarta.xml.ws.Endpoint;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class WebServiceConfig {
    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostConstruct
    public void publishEndpoint() {
        Endpoint.publish("http://0.0.0.0:9001/auth", authServiceImpl);
    }
}