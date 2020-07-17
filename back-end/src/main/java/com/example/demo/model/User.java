package com.example.demo.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class User {
    @NotBlank(message = "Empty name")
    @Length(min=1, max=15, message = "Name is too long or is too small")
    private String name;

    @NotBlank(message = "Empty surname")
    @Length(min=1, max=15, message = "Surname is too long or is too small")
    private String surname;

    @Email(message = "Incorrect email")
    private String email;

    private String info = "";

    @Pattern(regexp = "[a-zA-z]+\\S*", message = "Incorrect login")
    @Length(min=1, max=15, message = "Login is too long or is too small")
    private String login;

    @Pattern(regexp = "\\S+", message = "Incorrect password")
    @Length(min=1, max=10, message = "Password is too long or is too small")
    private String password;

    private Date createAt;

   // private boolean adminCredentials = false;

    public User() {
    }


    public User(String name, String surname, String email, String info, String login, String password, Date createAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.info = info;
        this.login = login;
        this.password = password;
        this.createAt = createAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

   /* public boolean isAdmin() {
        return adminCredentials;
    }

    public void setAdminCredentials(Boolean adminCredentials) {
        this.adminCredentials = adminCredentials;
    }*/

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(info, user.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, info);
    }
}
