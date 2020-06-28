package com.example.common.app;

import android.app.Application;
import android.content.Context;

public abstract class BaseApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        initOtherConfig();
    }

    //初始化其它配置
    protected abstract void initOtherConfig();

    //获取应用的上下文
    public static Context getAppContext(){
        return context;
    }
}
