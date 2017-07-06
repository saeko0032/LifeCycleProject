package com.example.ciccc_cirac.lifecycleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Saeko Fukui on 2017-07-06.
 */

public class IntentexampleA extends AppCompatActivity {
    //1. declare all the controls
    TextView t1;
    TextView t2;
    EditText editTxt1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentexample1);
        //2. bind all the controls

        t1 = (TextView) findViewById(R.id.txtA);
        t2 = (TextView) findViewById(R.id.textView1);
        b1 = (Button) findViewById(R.id.btnA);
        editTxt1 = (EditText) findViewById(R.id.editText1);

        //3. define the onclicklistner event
        b1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntentexampleA.this,IntentexampleB.class);
                i.putExtra("value",editTxt1.getText().toString());
                startActivity(i);
            }
        });
    }


}
