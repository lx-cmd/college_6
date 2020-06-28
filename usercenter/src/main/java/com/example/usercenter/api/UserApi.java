package com.example.usercenter.api;

import androidx.lifecycle.LiveData;

import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.entity.UserRegEntity;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {

    @POST("api/User/login")
    LiveData<BaseRespEntity<UserEntity>> login(@Body UserEntity userEntity);

    @POST("api/User/register")
    LiveData<BaseRespEntity<UserRegEntity>> register(@Body UserRegEntity userEntity);

    @FormUrlEncoded
    @POST("api/User/getAuthCode")
    LiveData<BaseRespEntity> getYzm(@Field("phoneNumber") String phoneNumber);
}