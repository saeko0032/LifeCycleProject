package com.example.ciccc_cirac.lifecycleproject.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/8/2017.
 */

public class ServiceActivity extends AppCompatActivity {
    private Button startBtn;
    private Button stopBtn;
    private Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_vew);
        startBtn = (Button)findViewById(R.id.buttonStart);
        startBtn.setOnClickListener(new View.OnClickListener(){
            Intent i;
            @Override
            public void onClick(View view) {
                i = new Intent(ServiceActivity.this, MyService.class);
                startService(i);
            }
        });
        stopBtn = (Button)findViewById(R.id.buttonStop);
        stopBtn.setOnClickListener(new View.OnClickListener(){
            Intent i;
            @Override
            public void onClick(View view) {
                i = new Intent(ServiceActivity.this, MyService.class);
                stopService(i);
            }
        });
        nextBtn = (Button)findViewById(R.id.buttonNext);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            Intent i;
            @Override
            public void onClick(View view) {
                i = new Intent(ServiceActivity.this, NextActivity.class);
                startActivity(i);
            }
        });

    }

}
