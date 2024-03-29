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

//  https://gitlab.com/myusufalpian/spring-boot-3.2-jwt-authentication
//  https://bootify.io/spring-security/rest-api-spring-security-with-jwt.html
//  https://spring.io/guides/tutorials/spring-security-and-angular-js

// https://www.geeksforgeeks.org/spring-boot-3-0-jwt-authentication-with-spring-security-using-mysql-database/
/*
    TODOs:
    -
 */