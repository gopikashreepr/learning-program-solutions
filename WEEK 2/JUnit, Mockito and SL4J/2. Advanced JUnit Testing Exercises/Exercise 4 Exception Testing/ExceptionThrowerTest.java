package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    public void testThrowsException() {
        ExceptionThrower et = new ExceptionThrower();

        // assertThrows checks for expected exception
        assertThrows(IllegalArgumentException.class, () -> {
            et.throwException("");  // Invalid input
        });

        assertThrows(IllegalArgumentException.class, () -> {
            et.throwException(null);  // Invalid input
        });
    }

    @Test
    public void testDoesNotThrowException() {
        ExceptionThrower et = new ExceptionThrower();

        assertDoesNotThrow(() -> {
            et.throwException("Hello JUnit!");
        });
    }
}
