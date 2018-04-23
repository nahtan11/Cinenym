package com.example.nathan.cinenym;

/**
 * Created by danie on 4/23/2018.
 */

public class User {
    private String username;
    private String bio;

    public User(){}

    public User(String username, String bio) {
        this.username = username;
        this.bio = bio;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
