package com.example;

public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData(String userId) {
        return externalApi.getData(userId);
    }
}
