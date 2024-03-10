package com.az.base.service;

import com.az.base.model.entity.CustomUserDetails;
import com.az.base.model.entity.UserInfo;
import com.az.base.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Entering in loadUserByUsername Method...");

        UserInfo user = userRepo.findByUsername(username);
        if (user == null) {
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("could not found user.");
        }

        logger.info("User Authenticated Successfully!");
        return new CustomUserDetails(user);
    }
}
