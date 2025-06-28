package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    public void testExternalApi() {
        Notifier mockApi = Mockito.mock(Notifier.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        NotificationService service = new NotificationService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}
