package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {
    private String username;
    private String password;
    private String confirm;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public RegistrationForm() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm() {
        return confirm;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone
        );
    }
}
