package com.crudtienda.crudtienda.Advice;

public class messageError {
    private String message;
    private int statusCode;
    

    public messageError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public int getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    

}
