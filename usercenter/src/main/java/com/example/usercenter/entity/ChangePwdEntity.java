package com.example.usercenter.entity;

import androidx.databinding.BaseObservable;

public class ChangePwdEntity extends BaseObservable {

    private String userid;
    private String id;

    public ChangePwdEntity() {
    }

    public ChangePwdEntity(String userid, String id) {
        this.userid = userid;
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
