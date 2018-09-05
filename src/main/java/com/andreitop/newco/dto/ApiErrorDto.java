package com.andreitop.newco.dto;

public class ApiErrorDto {

    private int status;
    private String message;

    public ApiErrorDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiErrorDto() {
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
