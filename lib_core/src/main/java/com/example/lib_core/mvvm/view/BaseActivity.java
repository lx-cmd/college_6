package com.example.lib_core.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.common.utils.MsgUtils;
import com.example.lib_core.R;
import com.example.lib_core.databinding.ActivityBaseBinding;

public abstract class BaseActivity<Binding extends ViewDataBinding,VM extends ViewModel> extends AppCompatActivity {

    protected Binding binding;

    protected VM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayout());

        vm = creatVM();

        initBinding();
    }

    //设置布局id
    protected abstract int getLayout();

    //创建 ViewModel
    protected abstract VM creatVM();

    //初始化绑定
    protected abstract void initBinding();

    protected void showToast(String msg){
        //Toast.makeText(this, msg + "", Toast.LENGTH_SHORT).show();
        MsgUtils.INSTANCE.showToast(this,msg);
    }

    protected String getResourcesString(int id){
        return getResources().getString(id);
    }
}