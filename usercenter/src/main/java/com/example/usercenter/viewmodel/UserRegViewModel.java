package com.example.usercenter.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.lib_core.mvvm.viewmodel.BaseViewModel;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.entity.UserRegEntity;
import com.example.usercenter.repository.UserRegRepository;
import com.example.usercenter.repository.UserRepository;

public class UserRegViewModel extends BaseViewModel {

    public UserRegEntity userRegEntity = new UserRegEntity();

    public UserRegViewModel(){
        registerRepository(UserRegRepository.class.getSimpleName(),new UserRegRepository());
    }

    public LiveData<BaseRespEntity<UserRegEntity>> register(){

        //userRegEntity = new UserRegEntity(1,username,pwd,"","","","",0);

        UserRegRepository repository = getRepository(UserRegRepository.class.getSimpleName());

        return repository.register(userRegEntity);
    }
}
