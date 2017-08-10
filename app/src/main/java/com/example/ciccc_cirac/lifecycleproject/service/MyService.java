package com.example.ciccc_cirac.lifecycleproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/8/2017.
 */

public class MyService extends Service {
    private MediaPlayer m;
    long seconds;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service is created", Toast.LENGTH_LONG).show();
        m = MediaPlayer.create(this, R.raw.music1);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is started", Toast.LENGTH_LONG).show();
        seconds = intent.getExtras().getLong("seconds");
        long milliSeconds = seconds * 1000;

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
//        m.start();
//        stopSelf();
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "Service is destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
        m.stop();
    }
}
