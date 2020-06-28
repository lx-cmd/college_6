package com.example.usercenter.repository;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.repository.Repository;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.entity.UserRegEntity;
import com.example.usercenter.model.UserModel;
import com.example.usercenter.model.UserRegModel;

public class UserRegRepository extends Repository<UserRegModel> {
    @Override
    protected UserRegModel creatModel() {
        return new UserRegModel();
    }

    public LiveData<BaseRespEntity<UserRegEntity>> register(UserRegEntity userEntity){
        return mModel.register(userEntity);
    }

}
