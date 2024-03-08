package com.az.base;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAdminServer
@SpringBootApplication
public class BaseZApplication {
    private static final Logger logger = LoggerFactory.getLogger(BaseZApplication.class);
    public static void main(String[] args) {
        logger.info("[AZ] - Starting ...");
        SpringApplication.run(BaseZApplication.class, args);
    }
}