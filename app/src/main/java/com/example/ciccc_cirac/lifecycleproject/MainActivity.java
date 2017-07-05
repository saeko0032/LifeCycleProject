package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg = " IS ANDROID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(msg,"The onCreate method()");
        TextView t = new TextView(this);
        t=(TextView)findViewById(R.id.test);
        t.setText("Define text lalala");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(msg,"The onStart method()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(msg,"The onRestart method()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg,"The onResume method()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg,"The onPause method()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg,"The onStop method()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg,"The onDestroy method()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
