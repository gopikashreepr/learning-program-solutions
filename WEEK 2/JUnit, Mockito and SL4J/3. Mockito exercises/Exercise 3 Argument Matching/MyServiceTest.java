package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub getData with any String argument
        when(mockApi.getData(anyString())).thenReturn("Matched");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("user123");

        assertEquals("Matched", result);

        // ✅ Verify that getData was called with "user123"
        verify(mockApi).getData(eq("user123"));
    }
}
