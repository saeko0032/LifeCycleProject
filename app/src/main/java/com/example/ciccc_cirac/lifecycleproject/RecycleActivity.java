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
}
