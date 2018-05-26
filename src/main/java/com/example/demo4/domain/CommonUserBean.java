package com.example.demo4.domain;

import java.util.Date;

public class CommonUserBean {

    private int id;

    private String username;

    private String password;

    private Date register_date;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public int getId() {

        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegister_date() {
        return register_date;
    }
}
