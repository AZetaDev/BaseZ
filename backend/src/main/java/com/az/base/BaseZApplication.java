package com.az.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseZApplication {
    private static final Logger logger = LoggerFactory.getLogger(BaseZApplication.class);
    public static void main(String[] args) {
        logger.info("[AZ] - Starting ...");
        SpringApplication.run(BaseZApplication.class, args);
    }
}


// ADD SWAGGER

// ADD JWT: https://medium.com/spring-boot/spring-boot-3-spring-security-6-jwt-authentication-authorization-98702d6313a5