package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PollingServiceTest {

    @Test
    public void testMultipleReturnValues() {
        PollingApi mockApi = mock(PollingApi.class);

        // 🔁 First call returns "LOADING", second returns "READY"
        when(mockApi.getStatus())
            .thenReturn("LOADING")
            .thenReturn("READY");

        PollingService service = new PollingService(mockApi);
        String result = service.checkTwice();

        assertEquals("LOADING -> READY", result);

        // Optional: verify it was called twice
        verify(mockApi, times(2)).getStatus();
    }
}
