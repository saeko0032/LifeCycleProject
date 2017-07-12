package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by saeko on 7/12/2017.
 */

public class GridExample extends AppCompatActivity {

    GridView gv;
    String[] title = {
            "cute",
            "execellent",
            "kawaii",
            "perfect",
            "angle",
            "chihuahua",
            "lovely",
            "memorable",
            "royal",
            "sweet",
            "little",
            "stinkey",
            "dog",
            "is",
            "kimchi"

    } ;

    int[] images =
            {
                    R.drawable.sample_0,
                    R.drawable.sample_1,
                    R.drawable.sample_2,
                    R.drawable.sample_3,
                    R.drawable.sample_4,
                    R.drawable.sample_5,
                    R.drawable.sample_6,
                    R.drawable.sample_7,
                    R.drawable.sample_0,
                    R.drawable.sample_1,
                    R.drawable.sample_2,
                    R.drawable.sample_3,
                    R.drawable.sample_4,
                    R.drawable.sample_5,
                    R.drawable.sample_6,
                    R.drawable.sample_7

            };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        GridAdapter adapter = new GridAdapter(this, this.title, this.images);
        gv = (GridView)findViewById(R.id.gv1);
        gv.setAdapter(adapter);

//use setOnItemClickListener on gridview and make a toast for item click event
    }

}