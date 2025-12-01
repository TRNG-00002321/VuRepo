package com.revature.daodemo.model;

public class Contacts {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Contacts() {
    }

    public Contacts(String phone, String email, String name) {
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public Contacts(int anInt, String string, String string1, String string2) {
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
