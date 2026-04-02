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
        String host = System.getenv("SOAP_HOST") != null 
            ? System.getenv("SOAP_HOST") 
            : "http://localhost:9002/auth";
        Endpoint.publish(host, authServiceImpl);
    }
}