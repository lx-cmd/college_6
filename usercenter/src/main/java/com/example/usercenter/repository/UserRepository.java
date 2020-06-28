package com.example.usercenter.repository;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.repository.Repository;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.entity.UserRegEntity;
import com.example.usercenter.model.UserModel;
import com.example.usercenter.model.UserRegModel;

public class UserRepository extends Repository<UserModel> {

    @Override
    protected UserModel creatModel() {
        return new UserModel();
    }


    public LiveData<BaseRespEntity<UserEntity>> login(UserEntity userEntity){
        return mModel.login(userEntity);
    }

    public LiveData<BaseRespEntity<UserRegEntity>> register(UserRegEntity userEntity){
        return mModel.register(userEntity);
    }
}