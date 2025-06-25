package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // Setup: Called before each test
        calc = new Calculator();
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() {
        // Teardown: Called after each test
        calc = null;
        System.out.println("Teardown completed");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calc.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }
}
