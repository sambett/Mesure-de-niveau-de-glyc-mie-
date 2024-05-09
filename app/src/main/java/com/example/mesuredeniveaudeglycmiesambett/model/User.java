package com.example.mesuredeniveaudeglycmiesambett.model;

public class User {
    private String userEmail;
    private String password;

    public User(String userName, String password) {
        this.userEmail = userName;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

}