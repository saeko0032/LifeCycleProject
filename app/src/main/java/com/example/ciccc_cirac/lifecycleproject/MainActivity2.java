package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.recycler.GreenAdapter1;

/**
 * Created by saeko on 7/17/2017.
 */

public class MainActivity2 extends AppCompatActivity implements GreenAdapter1.ListItemClickListener {
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
        adapter = new GreenAdapter1(LIST_COUNT, this);
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
            adapter = new GreenAdapter1(LIST_COUNT, this);
            recyclerView.setAdapter(adapter);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onListItemClick(int position) {
        Toast.makeText(this,"item #" + position + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
