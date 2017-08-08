package com.example.ciccc_cirac.lifecycleproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by saeko on 8/8/2017.
 */

public class MyService extends Service {
    private MediaPlayer m;

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
        m.start();
        stopSelf();
        return super.onStartCommand(intent, flags,startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "Service is destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
        m.stop();
    }
}
