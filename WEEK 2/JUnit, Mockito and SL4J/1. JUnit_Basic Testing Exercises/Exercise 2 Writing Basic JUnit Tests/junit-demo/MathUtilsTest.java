package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    MathUtils math = new MathUtils();

    @Test
    public void testAdd() {
        assertEquals(7, math.add(3, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, math.multiply(4, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(5, math.divide(10, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        math.divide(10, 0);
    }
}
