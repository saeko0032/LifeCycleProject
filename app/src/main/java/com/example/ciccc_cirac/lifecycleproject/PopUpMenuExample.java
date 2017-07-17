package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by saeko on 7/13/2017.
 */

public class PopUpMenuExample extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout
        setContentView(R.layout.popup_menu_example);
    }

    public void showPopUpMenu(View view) {
        // create popup menu
        PopupMenu popup = new PopupMenu(PopUpMenuExample.this,view);
        // Inflate the poup menu using xml menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuwithicon, popup.getMenu());
        Menu menu = popup.getMenu();
        //menu.setGroupCheckable(0,true,true);
        //menu.setGroupVisible(0, false);

        popup.show();
    }


}
