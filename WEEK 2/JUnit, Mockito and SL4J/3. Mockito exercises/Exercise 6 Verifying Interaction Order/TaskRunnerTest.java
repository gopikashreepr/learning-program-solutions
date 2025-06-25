package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class TaskRunnerTest {

    @Test
    public void testInteractionOrder() {
        TaskApi mockApi = mock(TaskApi.class);

        TaskRunner runner = new TaskRunner(mockApi);
        runner.runTask();

        // ✅ Verifying the exact order of method calls
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).initialize();
        inOrder.verify(mockApi).execute();
        inOrder.verify(mockApi).cleanup();
    }
}
