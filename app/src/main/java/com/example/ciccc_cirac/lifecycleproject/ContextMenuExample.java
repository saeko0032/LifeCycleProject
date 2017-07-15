package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by saeko on 7/13/2017.
 */

public class ContextMenuExample extends AppCompatActivity {
    ListView lv;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Mac OS","Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Mac OS "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // normallistviewex has simple listview
        setContentView(R.layout.normallistviewex);
        // acactivitylistview... has textview means list view item has only text view
        // mobile array show with list
        ArrayAdapter adapter = new  ArrayAdapter<String>(this,R.layout.acactivitylistview, mobileArray);

        // listview id from normallistview
        lv = (ListView)findViewById(R.id.mobile_list) ;
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        // menuwithicon is from menu it has <menu><item>
        inflater.inflate(R.menu.menuwithicon,menu);
        menu.setGroupVisible(0, false);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_bookmark)
            Toast.makeText(this, "bookmark is selected",Toast.LENGTH_SHORT).show();
        return true;
    }
}