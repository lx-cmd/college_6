package com.example.usercenter.view.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;

import com.example.lib_core.mvvm.view.BaseActivity;
import com.example.lib_net.procotol.BaseRespEntity;
import com.example.usercenter.R;
import com.example.usercenter.databinding.ActivityUserChangeBinding;
import com.example.usercenter.viewmodel.UserViewModel;

public class UserChangeActivity extends BaseActivity<ActivityUserChangeBinding, UserViewModel> {


    @Override
    protected int getLayout() {
        return R.layout.activity_user_change;
    }

    @Override
    protected UserViewModel creatVM() {
        return new UserViewModel();
    }

    @Override
    protected void initBinding() {

        binding.setVm(vm);

        binding.setChange(this);
    }

    public void change(View view){

    }

    public void getYzm(View view){

        //showToast("get yzm");

        LiveData<BaseRespEntity> data = vm.get("123");

        data.observe(this, new Observer<BaseRespEntity>() {
            @Override
            public void onChanged(BaseRespEntity baseRespEntity) {

                String s = baseRespEntity.getMsg() + "";

                showToast(s);
            }
        });
    }
}
