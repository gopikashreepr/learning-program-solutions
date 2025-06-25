package com.example;

public class PollingService {

    private PollingApi pollingApi;

    public PollingService(PollingApi pollingApi) {
        this.pollingApi = pollingApi;
    }

    public String checkTwice() {
        String first = pollingApi.getStatus();
        String second = pollingApi.getStatus();
        return first + " -> " + second;
    }
}
