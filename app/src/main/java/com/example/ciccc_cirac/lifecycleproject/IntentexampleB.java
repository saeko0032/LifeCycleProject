package com.example.ciccc_cirac.lifecycleproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Saeko Fukui on 2017-07-06.
 * Updated by SF on 2017-07-07.
 */

public class IntentexampleB extends AppCompatActivity {
    TextView t2;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentexample2);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("value");
        t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(msg);
        b2 = (Button) findViewById(R.id.btnB);
        b2.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String url = "http://www.stackoverflow.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                //  Intent i = new Intent(IntentexampleB.this,IntentexampleA.class);
                //  startActivity(i);
            }
        });
    }
}
