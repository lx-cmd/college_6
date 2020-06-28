package com.example.usercenter.model;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.model.IModel;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.lib_net.retrofit.RetrofitFactory;
import com.example.usercenter.api.UserApi;
import com.example.usercenter.entity.UserRegEntity;

public class UserRegModel implements IModel{
    public LiveData<BaseRespEntity<UserRegEntity>> register(UserRegEntity userEntity) {
        LiveData<BaseRespEntity<UserRegEntity>> register = RetrofitFactory.getRetrofitFactory()
                .create(UserApi.class)
                .register(userEntity);

        return register;
    }
}
