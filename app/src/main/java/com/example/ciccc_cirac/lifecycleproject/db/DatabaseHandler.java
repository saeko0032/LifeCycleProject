package com.example.ciccc_cirac.lifecycleproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by saeko on 8/14/2017.
 */

// To Create DB , I need to extends SQLiteOpenHelper
public class DatabaseHandler extends SQLiteOpenHelper {

    // create a database
    private Context myContext;
    public static final String DATABASE_NAME = "Bookdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "book";
    private static final String KEY_ID = "bookid";
    private static final String KEY_NAME = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String CREATE_TABLE_BOOKS =  "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER " +
            "PRIMARY KEY AUTOINCREMENT," + KEY_NAME +
            " TEXT," + KEY_AUTHOR +
            " TEXT " + ");";
    // create Constructor
    public DatabaseHandler(Context context) {
        // SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // cerate table book
        sqLiteDatabase.execSQL(CREATE_TABLE_BOOKS);
       // Toast.makeText(myContext, "Create data base", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    // if i want to add changing
        // this method will be called
        // delete tb and create tb again
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + CREATE_TABLE_BOOKS);
        this.onCreate(sqLiteDatabase);

    }

    public void addBook(Book book) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(KEY_NAME, book.getTitle());
        value.put(KEY_AUTHOR, book.getAuthor());

        db1.insert(TABLE_NAME, null, value);

        db1.close();
    }
}
