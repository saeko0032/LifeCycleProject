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

public class MainActivity2 extends AppCompatActivity {
    private static final int LIST_COUNT = 100;
    private GreenAdapter1 adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_example);  // recyclerview layout
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linerLayoutMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linerLayoutMng);
        adapter = new GreenAdapter1(LIST_COUNT);
        recyclerView.setAdapter(adapter);
    }

}
