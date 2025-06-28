package com.example;

public class MyService {
    private TaskApi externalApi;

    public MyService(TaskApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}
