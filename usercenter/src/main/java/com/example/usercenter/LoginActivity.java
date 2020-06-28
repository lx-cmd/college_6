package com.example.usercenter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.common.utils.LogUtils;
import com.example.lib_core.mvvm.view.BaseActivity;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.lib_net.procotol.TokenRespEntity;
import com.example.lib_net.retrofit.RetrofitFactory;
import com.example.usercenter.databinding.ActivityLoginBinding;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.model.api.UserApi2;
import com.example.usercenter.view.act.UserLoginActivity;
import com.example.usercenter.view.act.UserRegisterActivity;
import com.example.usercenter.viewmodel.UserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, UserViewModel> {

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected UserViewModel creatVM() {
        return new UserViewModel();
    }

    @Override
    protected void initBinding() {

       binding.setComand(this);
    }

    //跳转登录界面
    public void loginClick(View view){


        Intent intent = new Intent(LoginActivity.this, UserLoginActivity.class);
        startActivity(intent);

    }

    //跳转注册界面
    public void regClick(View view){
        Intent intent = new Intent(LoginActivity.this, UserRegisterActivity.class);
        startActivity(intent);
    }
}