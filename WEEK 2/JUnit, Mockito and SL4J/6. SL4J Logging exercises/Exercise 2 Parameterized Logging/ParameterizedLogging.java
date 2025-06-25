package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "Gopikashree";
        int loginAttempts = 3;

        logger.info("User {} has tried to login {} times", username, loginAttempts);
        logger.warn("Warning for user {} with attempt count: {}", username, loginAttempts);
    }
}
