package com.example.senior6_002;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() == "com.lx"){

            Notification.Builder notification = new Notification.Builder(context);
            notification.setSmallIcon(R.drawable.action_name)
                    .setContentTitle("获取到当前时间:"+intent.getStringExtra("time"));

            NotificationManager systemService = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            systemService.notify(0,notification.build());
        }
    }
}
