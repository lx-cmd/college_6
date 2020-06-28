package com.example.usercenter.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.viewmodel.BaseViewModel;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.entity.UserRegEntity;
import com.example.usercenter.repository.GetYzmRepository;
import com.example.usercenter.repository.UserRegRepository;
import com.example.usercenter.repository.UserRepository;

public class UserViewModel extends BaseViewModel {

    public UserEntity userEntity = new UserEntity();
    public UserRegEntity userRegEntity = new UserRegEntity();

    public UserViewModel(){
        registerRepository(UserRepository.class.getSimpleName(),new UserRepository());

        registerRepository(UserRegRepository.class.getSimpleName(),new UserRegRepository());

        registerRepository(GetYzmRepository.class.getSimpleName(),new GetYzmRepository());

    }

    public LiveData<BaseRespEntity<UserEntity>> login(){

        UserRepository repository = getRepository(UserRepository.class.getSimpleName());

        return repository.login(userEntity);
    }

    public LiveData<BaseRespEntity<UserRegEntity>> register(){

        //userRegEntity = new UserRegEntity(1,username,pwd,"","","","",0);

        UserRegRepository repository = getRepository(UserRegRepository.class.getSimpleName());

        return repository.register(userRegEntity);
    }

    public LiveData<BaseRespEntity> get(String msg){
        GetYzmRepository repository = getRepository(GetYzmRepository.class.getSimpleName());

        return repository.getYzm(msg);
    }
}