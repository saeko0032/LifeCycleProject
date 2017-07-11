package com.example.ciccc_cirac.lifecycleproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // text on which you are clicking
                String clickedPosition = Integer.toString(position);
                Toast t = Toast.makeText(getApplicationContext(),clickedPosition,Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
}