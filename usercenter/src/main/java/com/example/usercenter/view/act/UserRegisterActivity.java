package com.example.usercenter.view.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lib_core.mvvm.view.BaseActivity;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.R;
import com.example.usercenter.databinding.ActivityUserRegisterBinding;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.entity.UserRegEntity;
import com.example.usercenter.viewmodel.UserRegViewModel;
import com.example.usercenter.viewmodel.UserViewModel;

public class UserRegisterActivity extends BaseActivity<ActivityUserRegisterBinding, UserViewModel> {

    @Override
    protected int getLayout() {
        return R.layout.activity_user_register;
    }

    @Override
    protected UserViewModel creatVM() {
        return new UserViewModel();
    }

    @Override
    protected void initBinding() {

        binding.setVm(vm);

        binding.setReg(this);
    }

    public void register(View view){

        String username = vm.userRegEntity.getUsername();
        String pwd = vm.userRegEntity.getPwd();

        LiveData<BaseRespEntity<UserRegEntity>> register = vm.register();

        Log.d("liangxiao",username + pwd);

        register.observe(UserRegisterActivity.this, new Observer<BaseRespEntity<UserRegEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserRegEntity> userEntityBaseRespEntity) {

                showToast(userEntityBaseRespEntity.getMsg() + userEntityBaseRespEntity.getCode());
                //showToast(userEntityBaseRespEntity.getData().getUsername() + userEntityBaseRespEntity.getData().getPwd());

                if (userEntityBaseRespEntity!=null&&userEntityBaseRespEntity.getData()!=null) {
                    showToast("1111");
                }else {
                    showToast("2222");
                }
            }
        });
    }
}