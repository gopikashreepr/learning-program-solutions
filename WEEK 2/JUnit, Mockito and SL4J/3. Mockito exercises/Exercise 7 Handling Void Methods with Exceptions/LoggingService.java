package com.example;

public class LoggingService {

    private Logger logger;

    public LoggingService(Logger logger) {
        this.logger = logger;
    }

    public boolean safeLog(String message) {
        try {
            logger.log(message);
            return true;
        } catch (Exception e) {
            System.err.println("Logging failed: " + e.getMessage());
            return false;
        }
    }
}
