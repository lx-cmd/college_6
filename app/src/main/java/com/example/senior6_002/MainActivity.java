package com.example.senior6_002;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private TextView time;

    private MyReceiver receiver;

    private MyService.MyBind bind;

    private ServiceConnection mcn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bind = (MyService.MyBind) service;
            // 获取本地时间
            time.setText(bind.getDate() + "");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this, MyService.class);
        bindService(intent, mcn, Service.BIND_AUTO_CREATE);

        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.lx");
        registerReceiver(receiver,intentFilter);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        time = (TextView) findViewById(R.id.time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, MyService.class);
                //startService启动形式
                startService(startIntent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(MainActivity.this, MyService.class);
                //“启动”服务的停止
                stopService(stopIntent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PropertyValuesHolder scaleX1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f);
                PropertyValuesHolder rotation1 = PropertyValuesHolder.ofFloat("rotation", 0.0f, 360f);

                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(time, rotation1,scaleX1);

                AnimatorSet animatorSet = new AnimatorSet();
                //使用play方法把两个动画拼接起来
                animatorSet.play(objectAnimator);
                //时间
                animatorSet.setDuration(3000);
                //开始执行
                animatorSet.start();

                String t = time.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("time",t);
                intent1.setAction("com.lx");
                sendBroadcast(intent1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
