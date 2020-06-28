package com.example.usercenter.entity;

import androidx.databinding.BaseObservable;

public class UserRegEntity extends BaseObservable {

    private int id;
    private String username;
    private String pwd;
    private String sex;
    private String birthday;
    private String headerimg;
    private String nick;
    private int utype;


    public UserRegEntity(int id, String username, String pwd, String sex, String birthday, String headerimg, String nick, int utype) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
        this.headerimg = headerimg;
        this.nick = nick;
        this.utype = utype;
    }

    public UserRegEntity(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public UserRegEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(String headerimg) {
        this.headerimg = headerimg;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
    }
}
