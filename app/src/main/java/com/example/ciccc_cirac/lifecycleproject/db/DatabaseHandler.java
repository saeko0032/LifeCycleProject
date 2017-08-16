package com.example.ciccc_cirac.lifecycleproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * This class to manage to Database creation
 * @see SQLiteOpenHelper
 * @author saeko
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Bookdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "book";
    private static final String KEY_ID = "bookid";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String CREATE_TABLE_BOOKS =  "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER " +
            "PRIMARY KEY AUTOINCREMENT," + KEY_TITLE +
            " TEXT," + KEY_AUTHOR +
            " TEXT " + ");";
    private static final String DROP_TABLE = "DROP TABLE IF EXIST";
    private static final String OREDER_BY_TITLE = "ORDER BY " + KEY_TITLE + " ASC";

    private static final String OREDER_BY_AUTHOR = "ORDER BY " + KEY_AUTHOR + " ASC";

    /**
     * Constructor with context
     * execute creating db
     * @param context DBActivity
     */
    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * execute creating table name
     * @param sqLiteDatabase book db
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_BOOKS);
    }

    /**
     * Use this method when you want to drop, add or change db scheme
     * @see SQLiteOpenHelper#onUpgrade
     * @param sqLiteDatabase book db
     * @param oldVersion the old database version
     * @param newVersion the new database version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DROP_TABLE + CREATE_TABLE_BOOKS);
        this.onCreate(sqLiteDatabase);
    }

    /**
     * this method to insert customized book object to book table
     * @param book book object
     */
    public void addBook(Book book) {
        SQLiteDatabase tmpDB = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        // id is auto-increment value,
        // so we don't need to put id
        value.put(KEY_TITLE, book.getTitle());
        value.put(KEY_AUTHOR, book.getAuthor());

        tmpDB.insert(TABLE_NAME, null, value);
        tmpDB.close();
    }

    /**
     * update db row
     * @see SQLiteDatabase#update
     * @param book book data which will be updated
     * @return how many rows you updated // now always 1 row
     */
    public int update(Book book) {
        SQLiteDatabase tmpDB = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(KEY_TITLE, book.getTitle());
        value.put(KEY_AUTHOR, book.getAuthor());

        int result = tmpDB.update(TABLE_NAME, value, KEY_ID + " = ? ", new String[]{ String.valueOf(book.getId())});
        tmpDB.close();
        return result;
    }


    /**
     * delete db row
     * @param book book data which will be deleted
     * @return how many rows you deleted
     */
    public int delete(Book book) {
        SQLiteDatabase tmpDB = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(KEY_TITLE, book.getTitle());
        int result = tmpDB.delete(TABLE_NAME, KEY_ID + " = ? ", new String[] {String.valueOf(book.getId())});
        tmpDB.close();
        return result;
    }

    /**
     * get List of book's data from Database
     * @param type select db data by user needs
     * @return list of book's data
     */
    public List<Book> getAllBooks(int type) {
        List<Book> books = new LinkedList<Book>();

        String query;
        switch (type) {
            case DBActivity.TYPE_ORDER_BY_TITLE:
                query = "SELECT * FROM " + TABLE_NAME + " " +OREDER_BY_TITLE;
                break;
            case DBActivity.TYPE_ORDER_BY_AUTHOR:
                query = "SELECT * FROM " + TABLE_NAME + " " +OREDER_BY_AUTHOR;
                break;
            default:
                query = "SELECT * FROM " + TABLE_NAME;
                break;
        }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Book book;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                books.add(book);
            } while(cursor.moveToNext());
        }
        return books;
    }
}
