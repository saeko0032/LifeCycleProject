package com.example.ciccc_cirac.lifecycleproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by saeko on 8/18/2017.
 */

public class ContactActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        listView = (ListView) findViewById(R.id.contatc_list_View);
        arrayList = new ArrayList<String>();

        // minimum android 23
//        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//             ActivityCompat.requestPermissions(this, new String[] (android.Manifest.permission.READ_CONTACTS),1);

//        }
        Cursor cursor = getContentResolver().query(
        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
                );
        while(cursor.moveToNext()) {
            // we don't know where column has name
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            arrayList.add(name);
        }
        listView.setAdapter(new ArrayAdapter<String>(ContactActivity.this, android.R.layout.simple_list_item_1, arrayList));
    }
}
