package com.example.ciccc_cirac.lifecycleproject.db;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/14/2017.
 */

public class DBActivity extends AppCompatActivity{
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        db.addBook(new Book("AAA","AAA AUTHOR"));
        db.addBook(new Book("BBB","BBB AUTHOR"));

    }
}
