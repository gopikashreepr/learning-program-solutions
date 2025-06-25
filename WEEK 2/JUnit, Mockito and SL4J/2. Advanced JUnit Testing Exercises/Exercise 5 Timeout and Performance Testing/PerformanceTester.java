package com.example;

public class PerformanceTester {

    public void performTask() {
        try {
            // Simulating a task that takes 1 second
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void slowTask() {
        try {
            // Simulating a long task (e.g., 5 seconds)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
