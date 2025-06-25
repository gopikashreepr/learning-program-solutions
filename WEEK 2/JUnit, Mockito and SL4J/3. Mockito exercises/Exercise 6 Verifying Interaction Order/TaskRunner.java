package com.example;

public class TaskRunner {

    private TaskApi taskApi;

    public TaskRunner(TaskApi taskApi) {
        this.taskApi = taskApi;
    }

    public void runTask() {
        taskApi.initialize();
        taskApi.execute();
        taskApi.cleanup();
    }
}
