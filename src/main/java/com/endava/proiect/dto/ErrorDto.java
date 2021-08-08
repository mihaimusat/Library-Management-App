package com.endava.proiect.dto;

public class ErrorDto {

    private String message;
    private String errorCode;
    private Integer status;

    public ErrorDto() {
    }

    public ErrorDto(String message, String errorCode, Integer status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
