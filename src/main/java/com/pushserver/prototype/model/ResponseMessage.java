package com.pushserver.prototype.model;

public class ResponseMessage {
    private int status;
    private String message;

    public ResponseMessage(int status,String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseMessage() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
