package com.example.ciccc_cirac.lifecycleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by saeko on 7/18/2017.
 */

public class LinearLayoutActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        btn1 = (Button) findViewById(R.id.linear_btn_home);
        btn1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // go back screenA
                Intent i = new Intent(LinearLayoutActivity.this,ListViewActivity.class);
                startActivity(i);
            }
        });
        btn2 = (Button) findViewById(R.id.linear_btn_next);
        btn2.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // go back screenA
                Intent i = new Intent(LinearLayoutActivity.this,ListViewActivity2.class);
                startActivity(i);
            }
        });
    }
}
