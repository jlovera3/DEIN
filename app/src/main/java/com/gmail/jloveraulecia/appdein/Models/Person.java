package com.gmail.jloveraulecia.appdein.Models;

public class Person {
    private Integer id=null;
    private String user ="";
    private String email ="";
    private String image ="";

    public Person() {}

    public Person(Integer id, String user, String email) {
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public Person(Integer id, String user, String email, String image) {
        this.id=id;
        this.user = user;
        this.email = email;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }
}
