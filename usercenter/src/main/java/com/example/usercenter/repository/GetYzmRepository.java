package com.example.usercenter.repository;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.repository.Repository;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.model.UserModel;

public class GetYzmRepository  extends Repository<UserModel> {
    @Override
    protected UserModel creatModel() {



        return new UserModel();
    }

    public LiveData<BaseRespEntity> getYzm(String msg){

        return mModel.getYzm(msg);
    }
}
