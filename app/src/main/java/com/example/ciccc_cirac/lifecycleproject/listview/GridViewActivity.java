package com.example.ciccc_cirac.lifecycleproject.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 7/18/2017.
 */

public class GridViewActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
        btn1 = (Button) findViewById(R.id.grid_btn_home);
        btn1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // go back screenA
                Intent i = new Intent(GridViewActivity.this,ListViewActivity.class);
                startActivity(i);
            }
        });
        btn2 = (Button) findViewById(R.id.grid_btn_next);
        btn2.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // go back screenA
                Intent i = new Intent(GridViewActivity.this,RecyclerViewActivity.class);
                startActivity(i);
            }
        });
    }
}
