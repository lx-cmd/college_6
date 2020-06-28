package com.example.usercenter.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lib_core.mvvm.model.IModel;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.lib_net.retrofit.RetrofitFactory;
import com.example.usercenter.api.UserApi;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.entity.UserRegEntity;

import io.reactivex.disposables.Disposable;

public class UserModel implements IModel {

    private final String TAG=UserModel.class.getSimpleName();
    Disposable disposable=null;
    /**
     * 登录方法
     * @param userEntity
     * @return
     */
    public LiveData<BaseRespEntity<UserEntity>> login(final UserEntity userEntity){
        //final MutableLiveData<BaseRespEntity<UserEntity>> result=new MutableLiveData<>();
        LiveData<BaseRespEntity<UserEntity>> login = RetrofitFactory.getRetrofitFactory()
                .create(UserApi.class)
                .login(userEntity);

        return login;
    }

    public LiveData<BaseRespEntity<UserRegEntity>> register(final UserRegEntity userEntity){
        //final MutableLiveData<BaseRespEntity<UserEntity>> result=new MutableLiveData<>();
        LiveData<BaseRespEntity<UserRegEntity>> register = RetrofitFactory.getRetrofitFactory()
                .create(UserApi.class)
                .register(userEntity);

        return register;
    }

    public LiveData<BaseRespEntity> getYzm(String msg){
        LiveData<BaseRespEntity> yzm = RetrofitFactory.getRetrofitFactory()
                .create(UserApi.class)
                .getYzm(msg);

        return yzm;
    }
}