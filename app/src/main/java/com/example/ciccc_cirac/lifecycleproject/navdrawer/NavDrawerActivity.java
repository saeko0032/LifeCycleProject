package com.example.ciccc_cirac.lifecycleproject.navdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/30/2017.
 */

public class NavDrawerActivity extends AppCompatActivity {
    private ListView mDrawerListView;
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        mDrawerListView = (ListView) findViewById(R.id.nav_list);
        addDrawerItems();
    }
    private void addDrawerItems() {
        String[] osArray = {"Android", "iOS", "windows"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        // ListView<-adapter<-array<-string
        mDrawerListView.setAdapter(mAdapter);

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NavDrawerActivity.this, "you choose a OS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
