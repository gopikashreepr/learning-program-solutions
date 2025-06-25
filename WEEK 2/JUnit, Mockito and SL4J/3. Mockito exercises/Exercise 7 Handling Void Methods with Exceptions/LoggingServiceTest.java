package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoggingServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        Logger mockLogger = mock(Logger.class);

        // ❗ Simulate throwing exception on log()
        doThrow(new RuntimeException("Disk full")).when(mockLogger).log("Critical error");

        LoggingService service = new LoggingService(mockLogger);
        boolean result = service.safeLog("Critical error");

        assertFalse(result); // ✅ Ensure the service handled it
    }
}
