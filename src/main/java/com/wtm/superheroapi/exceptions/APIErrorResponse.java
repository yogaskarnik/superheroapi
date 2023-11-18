package com.wtm.superheroapi.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class APIErrorResponse {
    LocalDateTime timestamp;
    int status;
    String error;
    String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public APIErrorResponse(LocalDateTime timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public static APIErrorResponse create(HttpStatus status, String message) {
        return new APIErrorResponse(LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message);
    }

}
