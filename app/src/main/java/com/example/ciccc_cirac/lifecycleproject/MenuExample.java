package com.example.ciccc_cirac.lifecycleproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by CICCC-CIRAC on 2017-07-11.
 */

public class MenuExample extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getResources must be called after onCreate
        Resources res = this.getResources();
        String[] menuItems = res.getStringArray(R.array.menu_items);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.menutext, menuItems);
        ListView listView = (ListView) findViewById(R.id.list_menu);
        listView.setAdapter(adapter);
    }
}