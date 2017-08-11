package com.example.ciccc_cirac.lifecycleproject.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/11/2017.
 */

public class BroadcastActivity extends AppCompatActivity {

    BroadcastReceiveDemo myBroadcast;
    IntentFilter intentFilter;
    Button broadcastBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_view);

        myBroadcast = new BroadcastReceiveDemo();
        intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        broadcastBtn = (Button)findViewById(R.id.broadcast_btn);
        broadcastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
                sendBroadcast(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcast,
                intentFilter);
    }
}
