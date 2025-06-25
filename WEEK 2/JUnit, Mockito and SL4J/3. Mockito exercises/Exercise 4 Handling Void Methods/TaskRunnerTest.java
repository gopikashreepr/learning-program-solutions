package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TaskRunnerTest {

    @Test
    public void testNotifyUser_callsSend() {
        // Create mock of TaskApi
        TaskApi mockApi = mock(TaskApi.class);

        // Create TaskRunner with mock TaskApi
        TaskRunner runner = new TaskRunner(mockApi);

        // Call notifyUser, which internally calls the void send method
        String testMessage = "Hello Mockito!";
        runner.notifyUser(testMessage);

        // Verify that send() was called once with the correct argument
        verify(mockApi, times(1)).send(testMessage);
    }
}
