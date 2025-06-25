package com.example;

public class ExceptionThrower {

    public void throwException(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        System.out.println("Message is valid: " + message);
    }
}
