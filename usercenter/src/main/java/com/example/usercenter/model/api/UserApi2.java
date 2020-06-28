package com.example.usercenter.model.api;

import com.example.lib_net.common.Config;
import com.example.lib_net.procotol.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface UserApi2 {

    @Headers({Config.NewUrlHeaderKey+":" + Config.NewUrlHeaderValue})
    @GET("/login")
    Call<TokenRespEntity> getTest();
}
