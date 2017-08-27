package com.example.ciccc_cirac.lifecycleproject.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/25/2017.
 */

public class NotificationDemo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }

    public void testNotification(View view)
    {
        NotificationUtils.remindUser(this);
    }
}
