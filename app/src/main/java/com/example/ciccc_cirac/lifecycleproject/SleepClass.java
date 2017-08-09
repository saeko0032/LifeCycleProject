package com.example.ciccc_cirac.lifecycleproject;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;


/**
 * Created by saeko on 8/9/2017.
 */

public class SleepClass extends IntentService {
    long seconds;
    public SleepClass(){
        super("SleepClass");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        seconds = intent.getExtras().getLong("seconds");
        long milliseconds = seconds * 1000;
        try {
            Toast.makeText(this,"Inten service started", Toast.LENGTH_LONG).show();
            Thread.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Inten service destroyed", Toast.LENGTH_LONG).show();
    }
}
