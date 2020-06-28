package com.example.senior6_002;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyService extends Service {

    private static final String TAG = "MyService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bind;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public class MyBind extends Binder {
        // 获取随机数方法(0-9)
        public String getRandom() {
            Random random = new Random();
            return random.nextInt(9) + "";
        }

        // 获取本地时间
        public String getDate() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy年MM月dd日  HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String timeDate = simpleDateFormat.format(date);
            return timeDate;
        }
    }

    // 实例化
    MyBind bind = new MyBind();

    /*@Override
    public IBinder onBind(Intent intent) {
        return bind;
    }*/
}