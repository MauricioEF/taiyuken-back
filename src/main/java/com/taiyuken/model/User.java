package com.taiyuken.model;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String type;

    public User(int id, String name, String username, String email, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getType() {
        return this.type;
    }
}


