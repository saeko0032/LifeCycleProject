package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by saeko on 7/17/2017.
 */

public class RecycleActivity extends AppCompatActivity {
    private static int COUNTER = 100;
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_example);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linaeraMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linaeraMng);
        adapter = new RecyclerAdapter(COUNTER);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh_example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            return true;

        } else if (id == R.id.action_refresh) {
            // Refresh adapter
            // should create adapter again!!
            adapter = new RecyclerAdapter(COUNTER);
            recyclerView.setAdapter(adapter);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
