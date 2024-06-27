package com.example.socket_chat_app.model;

public class ActiveUser {

    private String userName;
    private String session;

    public ActiveUser() {
    }

    public ActiveUser(String userName, String session) {
        this.userName = userName;
        this.session = session;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
