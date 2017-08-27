package com.example.ciccc_cirac.lifecycleproject.userDicitionary;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.R;

import java.util.Locale;

/**
 * Created by saeko on 8/18/2017.
 */

public class UserDictionaryActivity  extends AppCompatActivity implements View.OnClickListener{

    private  String details="The words in your personal dictionary are \n\n";
    Button insert,display;
    EditText et;
    TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdictionary);
        insert=(Button)findViewById(R.id.iword);
        display=(Button)findViewById(R.id.dword);
        et=(EditText) findViewById(R.id.editText1);
        d=(TextView)findViewById(R.id.Display);

        insert.setOnClickListener(this);
        display.setOnClickListener(this);

        ContentResolver contentResolver= getContentResolver();

        retrieveData(contentResolver);
        insertData(contentResolver);
        updateData(contentResolver);
        deleteData(contentResolver);
    }


    protected void retrieveData( ContentResolver contentResolver ){
// A "projection" defines the columns that will be returned for each row
        String[] mProjection =
                {
                        UserDictionary.Words._ID,    // Contract class constant for the _ID column name
                        UserDictionary.Words.WORD,   // Contract class constant for the word column name
                        UserDictionary.Words.LOCALE  // Contract class constant for the locale column name
                };
        // Defines a string to contain the selection clause
        String mSelectionClause = null;

// Initializes an array to contain selection arguments
        String[] mSelectionArgs = {""};
        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);
        Log.e("Word Count", cursor.getCount() + "");

        while (cursor.moveToNext()) {

            String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
            Log.e("Dictionary Word", word);
        }
        cursor.close();
    }
    //  Insert data into user dictionary
    protected void insertData( ContentResolver contentResolver ){

        Uri resultUri;

        // create a content values (kay- value pair)
        //Create an object to contain the new values to insert
        ContentValues newValues = new ContentValues();

        newValues.put(UserDictionary.Words.APP_ID, "example.user");
        newValues.put(UserDictionary.Words.LOCALE, "en_US");
        newValues.put(UserDictionary.Words.WORD, "insert");
        newValues.put(UserDictionary.Words.FREQUENCY, "100");

        // 1. get content resolver object via getContentResolver()
        // 2. use insert() pass two arguments URi and Values
        //3. URI
        //4. vcontent values

        resultUri = getContentResolver().insert(
                UserDictionary.Words.CONTENT_URI,
                newValues
        );



        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        Log.e("Word Count", cursor.getCount() + "");

        while (cursor.moveToNext()) {

            String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
            Log.e("Dictionary Word", word);
        }
        cursor.close();
    }

    protected void updateData( ContentResolver contentResolver ){

        ContentValues updateValues = new ContentValues();
        updateValues.put(UserDictionary.Words.LOCALE, "fr_");


        String selectionClause = UserDictionary.Words.LOCALE +  " LIKE ?";
        String[] selectionArgs = {"en_%"};

        // Defines a variable to contain the number of updated rows
        int updatedRows = 0;

        updatedRows = getContentResolver().update(
                UserDictionary.Words.CONTENT_URI,
                updateValues,
                selectionClause,
                selectionArgs
        );
        Log.e("updated rows", updatedRows+"");


        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        Log.e("Word Count", cursor.getCount() + "");

        while (cursor.moveToNext()) {

            String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
            Log.e("Dictionary Word", word);
        }
        cursor.close();
    }


    protected void deleteData( ContentResolver contentResolver ){

        String selectionClause = UserDictionary.Words.LOCALE +  " LIKE ? ";
        String[] selectionArgs = {"en_%"};

        // Defines a variable to contain the number of deleted rows
        int deletedRows = 0;

        deletedRows = getContentResolver().delete(
                UserDictionary.Words.CONTENT_URI,
                selectionClause,
                selectionArgs
        );

        Log.e("deleted rows", deletedRows+"");

        Cursor cursor = contentResolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        Log.e("Word Count", cursor.getCount() + "");

        while (cursor.moveToNext()) {

            String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
            Log.e("Dictionary Word", word);
        }
        cursor.close();
    }

    @Override
    public void onClick(View v) {
        Locale locale = Locale.getDefault(Locale.Category.DISPLAY);

        if (v.getId() == R.id.iword) {
            //insert the word to the User Dictionary
            UserDictionary.Words.addWord(this,et.getText().toString(),100,"st", locale);
            Toast.makeText(getApplicationContext(), "Word Successfully Added to USER DICTIONARY", Toast.LENGTH_SHORT).show();

        }
        if (v.getId() == R.id.dword) {
            //Display all the words from User Dictionary

            Uri dic = UserDictionary.Words.CONTENT_URI;
            ContentResolver resolver = getContentResolver();
            Cursor cursor = resolver.query(dic, null, null, null, null);
            d.setText("");
            while (cursor.moveToNext()) {
                String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
                d.append("\nword: " + word);
                Log.d("data ",word);
                retrieveData(resolver);
            }
        }
    }
}