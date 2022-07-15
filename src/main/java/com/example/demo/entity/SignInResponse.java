package com.example.demo.entity;

public class SignInResponse {
    private String token;
    private String status;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SignInResponse(String status, String token) {
        this.token = token;
        this.status = status;
    }

    public SignInResponse() {
    }
}
