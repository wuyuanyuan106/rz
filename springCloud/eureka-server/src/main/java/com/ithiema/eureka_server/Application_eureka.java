package com.ithiema.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application_eureka {
    public static void main(String[] args) {
        SpringApplication.run(Application_eureka.class, args);
        
    }
}
