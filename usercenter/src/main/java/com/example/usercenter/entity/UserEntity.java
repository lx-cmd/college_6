package com.example.usercenter.entity;

import androidx.databinding.BaseObservable;

public class UserEntity extends BaseObservable  {

    private String username;
    private String pwd;

    public UserEntity() {
    }

    public UserEntity(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
