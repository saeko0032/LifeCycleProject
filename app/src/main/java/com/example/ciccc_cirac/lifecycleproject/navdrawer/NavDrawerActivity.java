package com.example.ciccc_cirac.lifecycleproject.navdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    // need toggle for open or close
    private ActionBarDrawerToggle mDrawerToggle;
    // update the title in the actionbar
    private String mActionBarTitle;
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        mDrawerListView = (ListView) findViewById(R.id.nav_list);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActionBarTitle = getTitle().toString();
        addDrawerItems();
        //set up open / close
        setupDrawer();
        // add a toggle switch in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void addDrawerItems() {
        String[] osArray = {"Android", "iOS", "windows"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        // ListView<-adapter<-array<-string
        mDrawerListView.setAdapter(mAdapter);

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NavDrawerActivity.this, "you choose a OS", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupDrawer() {
        // initialize mDrawerToggle that uses context
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("navigation");
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActionBarTitle);
            }
        };
        // enabled the drawer indicator
        // attach into the toggle object
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        // DrawerLayout <- listener <- toggle
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        // when a drawer is completey open
        //
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // set rotation changed
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
