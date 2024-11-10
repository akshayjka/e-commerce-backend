package com.example.E_Commerce.register.response;

public class ResponseDTO {
    private int statuscode ;
    private String message;
    private String token;

    
    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }


    public int getStatuscode() {
        return statuscode;
    }


    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public ResponseDTO(int statuscode, String message, String token) {
        this.statuscode = statuscode;
        this.message = message;
        this.token = token;
    }
}

