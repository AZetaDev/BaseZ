package com.az.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseZApplication {

    private static final Logger logger = LoggerFactory.getLogger(BaseZApplication.class);
    public static void main(String[] args) {
        logger.info("Init app - INFO");
        logger.debug("Init app - DEBUG");
        logger.warn("Init app - WARN");
        logger.trace("Init app - TRACE");
        logger.error("Init app - ERROR");
        SpringApplication.run(BaseZApplication.class, args);
    }
}


/*
    Next:

    UNIT TESTING:
        https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
        https://mvnrepository.com/artifact/org.mockito/mockito-core

    LOMBOK: https://mvnrepository.com/artifact/org.projectlombok/lombok
 */