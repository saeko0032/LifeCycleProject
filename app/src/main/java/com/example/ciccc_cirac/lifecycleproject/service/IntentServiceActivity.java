package com.example.ciccc_cirac.lifecycleproject.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.ciccc_cirac.lifecycleproject.R;

public class IntentServiceActivity extends AppCompatActivity  implements View.OnClickListener {
    Button buttonStart, buttonStop, buttonNext, buttonIntent;
    Button buttonHandler;
    EditText sleepTime;
    Long secondstoSleep;
    private Handler handler;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_vew);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        setContentView(R.layout.activity_main);
        handler = new Handler();

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonIntent = (Button) findViewById(R.id.buttonIntent);
        sleepTime = (EditText) findViewById(R.id.editSeconds);
        buttonHandler = (Button) findViewById(R.id.buttonHandler);

        buttonStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntentServiceActivity.this, MyService.class);
                startService(i);
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntentServiceActivity.this, MyService.class);
                stopService(i);
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                Intent i = new Intent(IntentServiceActivity.this, MyService.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
            }
        });
        buttonIntent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                Intent i = new Intent(IntentServiceActivity.this, MyService.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
            }
        });
        buttonHandler.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonStart:
                Intent i = new Intent(this, MyService.class);
                startService(i);
                break;
            case R.id.buttonStop:
                i = new Intent(this, MyService.class);
                stopService(i);
                break;
            case R.id.buttonNext:
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                i = new Intent(this, MyService.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
                break;
            case R.id.buttonIntent:
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                i = new Intent(this, SleepClass.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
                break;

        }
    }



}