package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    MathUtils math = new MathUtils();

    @Test
    public void testAdd() {
        assertEquals(9, math.add(4, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, math.multiply(4, 5));
    }
}
