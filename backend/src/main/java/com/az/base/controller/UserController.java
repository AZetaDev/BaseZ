package com.az.base.controller;

import com.az.base.dto.UserInfo;
import com.az.base.model.AuthRequest;
import com.az.base.service.JwtService;
import com.az.base.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserInfoService userInfoService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserInfoService userInfoService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userInfoService = userInfoService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo user) {
        return userInfoService.addUser(user);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (AuthenticationException ex) {
            logger.error("[AZ] - Authentication failed: {}", ex.getMessage());
        }

        if (authentication != null && authentication.isAuthenticated()) {
            logger.info("[AZ] - Authenticated");
            String token = jwtService.generateToken(authRequest.getUsername());
            logger.info("[AZ] - Generated token: {}", token);
            return token;
        } else {
            logger.info("[AZ] - Not Authenticated");
            throw new UsernameNotFoundException("Invalid user request !");
        }
    }
}