package com.dakakolp.newapplication.data.classes;

public class User {
    private String mUsername;
    private String mPassword;

    public User(String username, String password) {

        this.mUsername = username;
        this.mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        this.mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}
