package com.newrock.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;

public class ThirdService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 被启动后创建相互id的通知栏，并提权服务
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        startForeground(250, builder.build());

        //开启新的线程消除通知栏
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                stopForeground(true);//停止前台
                NotificationManager manager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(250); // 消除通知栏
                stopSelf(); // 停止服务
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
