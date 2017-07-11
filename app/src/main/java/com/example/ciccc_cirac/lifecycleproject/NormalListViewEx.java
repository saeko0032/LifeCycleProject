package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by CICCC-CIRAC on 2017-07-11.
 */

public class NormalListViewEx extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Mac OS","Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Mac OS "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normallistviewex); // List view (id should be same as TextView)
        //Array Adapter Takes 3 parameters
        //1. context, 2. Layout, 3. Data
        ArrayAdapter a = new
                ArrayAdapter<String>(this,R.layout.acactivitylistview,mobileArray);
        ListView l = (ListView)findViewById(R.id.mobile_list) ;
        l.setAdapter(a);
    }
}