package com.example;

import org.junit.jupiter.api.Test;

import com.example.PerformanceTester;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformTaskWithinTime() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            tester.performTask();  // Should pass (1 sec < 2 sec)
        });
    }

    @Test
    public void testSlowTaskFailsTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(6), () -> {
            tester.slowTask(); // now 5 sec < 6 sec
        });
    }

}
