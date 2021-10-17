package com.sigsauer.asker.extapi.shared;

import com.google.gson.GsonBuilder;

public class ResponseWrapper {

    private final long timestamp = System.currentTimeMillis();
    private ApiResponse response;

    public ResponseWrapper(ApiResponse response) {
        this.response = response;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(ApiResponse response) {
        this.response = response;
    }

    public String json() {
        return (new GsonBuilder()).setPrettyPrinting().create().toJson(this.response);
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "timestamp=" + timestamp +
                ", response=" + response +
                '}';
    }
}
