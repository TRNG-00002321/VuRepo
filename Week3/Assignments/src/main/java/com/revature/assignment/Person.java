package com.revature.assignment;

import java.util.Optional;

public class Person {
    private String name;
    private String phone;
    private Optional<Address> address;

    public Person() {
    }

    public Person(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = Optional.ofNullable(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }
}
