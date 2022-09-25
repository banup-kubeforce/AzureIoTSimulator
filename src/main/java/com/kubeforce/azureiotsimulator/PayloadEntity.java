package com.kubeforce.azureiotsimulator;

import java.time.LocalDateTime;

public class PayloadEntity {

    private final LocalDateTime timestamp;
    private final String message;

    public PayloadEntity(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}