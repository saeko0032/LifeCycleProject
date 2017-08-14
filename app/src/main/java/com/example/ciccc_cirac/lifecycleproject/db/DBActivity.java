package com.example.ciccc_cirac.lifecycleproject.db;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/14/2017.
 */

public class DBActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHandler db = new DatabaseHandler(this);

    EditText title;
    EditText author;
    Button addBtn;
    Button updateBtn;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_view);

        db.addBook(new Book("AAA","AAA AUTHOR"));
        db.addBook(new Book("BBB","BBB AUTHOR"));
        Toast.makeText(this, "DB create successfully", Toast.LENGTH_LONG).show();

        title = (EditText) findViewById(R.id.db_title);
        author = (EditText) findViewById(R.id.db_author);
        addBtn = (Button) findViewById(R.id.db_add);
        updateBtn = (Button) findViewById(R.id.db_update);
        deleteBtn = (Button) findViewById(R.id.db_delete);
        addBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.db_add:
                db.addBook(new Book(title.getText().toString(), author.getText().toString()));
                Toast.makeText(this, "adding successfully", Toast.LENGTH_LONG).show();
                break;
            case R.id.db_update:
                break;
            case R.id.db_delete:
                db.delete();
                break;

        }
    }
}
