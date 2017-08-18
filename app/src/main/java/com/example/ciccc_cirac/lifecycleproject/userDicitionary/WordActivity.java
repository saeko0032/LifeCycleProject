package com.example.ciccc_cirac.lifecycleproject.userDicitionary;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 8/18/2017.
 */

public class WordActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "WordActivity";
    TextView word;
    Button listall, listfirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_main);
        word = (TextView)findViewById(R.id.tv_words);
        listall = (Button)findViewById(R.id.btn_list);
        listfirst = (Button) findViewById(R.id.btn_first);
        listfirst.setOnClickListener(this);
        listfirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String queryUri = Contract.CONTENT_URI.toString();
        String[] projection = new String[] {Contract.CONTENT_PATH};
        Cursor cursor;
        String selectionClause;
        String[] selectionArgs;
        switch(v.getId())
        {
            case R.id.btn_first:
                selectionClause = Contract.WORD_ID + " = ?";
                selectionArgs = new String[] {"0"};
                break;
            case R.id.btn_list:
                selectionClause = null;
                selectionArgs = null;
                break;
            default:
                selectionClause = null;
                selectionArgs = null;
        }
        cursor = getContentResolver().query(Uri.parse(queryUri), projection, selectionClause, selectionArgs, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(projection[0]);
                do {
                    String word1 = cursor.getString(columnIndex);
                    word.append(word1 + "\n");
                } while (cursor.moveToNext());
            } else {
                Log.d(TAG, "onClickDisplayEntries " + "No data returned.");
                word.append("No data returned." + "\n");
            }
            cursor.close();
        } else {
            Log.d(TAG, "onClickDisplayEntries " + "Cursor is null.");
            word.append("Cursor is null." + "\n");
        }

    }
}