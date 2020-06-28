package com.example.usercenter.view.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.lib_core.databinding.ActivityBaseBinding;
import com.example.lib_core.mvvm.view.BaseActivity;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.storage.MySPutils;
import com.example.usercenter.R;
import com.example.usercenter.databinding.ActivityUserLoginBinding;
import com.example.usercenter.entity.UserEntity;
import com.example.usercenter.viewmodel.UserViewModel;

public class UserLoginActivity extends BaseActivity<ActivityUserLoginBinding, UserViewModel> {

    private CheckBox check;

    @Override
    protected int getLayout() {
        return R.layout.activity_user_login;
    }

    @Override
    protected UserViewModel creatVM() {
        return new UserViewModel();
    }

    @Override
    protected void initBinding() {
        check = (CheckBox) findViewById(R.id.check);

        binding.setVm(vm);

        binding.setComand(this);
    }

    public void loginClick(View view){

        String username = vm.userEntity.getUsername();
        String pwd = vm.userEntity.getPwd();
        if (TextUtils.isEmpty(username)){
            showToast(getResourcesString(R.string.user_hint_username));
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            showToast(getResourcesString(R.string.user_hint_password));
            return;
        }
        Log.d("liangxiao",username + pwd);


        LiveData<BaseRespEntity<UserEntity>> result = vm.login();

        result.observe(this, new Observer<BaseRespEntity<UserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
                if (userEntityBaseRespEntity!=null&&userEntityBaseRespEntity.getData()!=null){
                    showToast(getResourcesString(R.string.user_login_success));

                    if (check.isChecked()){
                        MySPutils.put(UserLoginActivity.this,"name",vm.userEntity.getUsername());
                        MySPutils.put(UserLoginActivity.this,"pwd",vm.userEntity.getPwd());

                        String o1 = (String) MySPutils.get(UserLoginActivity.this, "name", "username_null");
                        String o2 = (String) MySPutils.get(UserLoginActivity.this, "pwd", "pwd_null");

                        showToast(o1 + "已存储---" + "密码为:" + o2);
                    }
                }else{
                    showToast(getResourcesString(R.string.user_login_failed));
                }
            }
        });
    }

    public void changePwd(View view){
        Intent intent = new Intent(UserLoginActivity.this, UserChangeActivity.class);
        startActivity(intent);
    }
}
