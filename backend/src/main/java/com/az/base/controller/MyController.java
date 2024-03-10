package com.az.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("api/v1/salute/{name}")
    public String salute(@PathVariable String name) {
        return "Hey, " + name + "!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("api/v1/hello")
    public String hello(){
        logger.info("Hello!");
        return "Epa!";
    }
}
