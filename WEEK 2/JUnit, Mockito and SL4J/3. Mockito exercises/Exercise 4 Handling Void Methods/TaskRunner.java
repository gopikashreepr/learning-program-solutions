package com.example;

public class TaskRunner {

    private TaskApi notifier;

    public TaskRunner(TaskApi notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        notifier.send(message);
    }
}
