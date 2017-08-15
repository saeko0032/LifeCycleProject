package com.example.ciccc_cirac.lifecycleproject.db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciccc_cirac.lifecycleproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Activity class for DB
 * for button - View.OnClickListener
 * for list item - Adapter.OnItemClickListener
 * @author saeko
 */
public class DBActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText title;
    EditText author;
    Button addBtn;
    Button updateBtn;
    Button deleteBtn;
    ListView bookListview;
    BookAdapter bookAdapter;
    List<Book> bookList;

    /**
     * set xml file data and update all db data and set it for the adapter
     * @see AppCompatActivity#onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_view);

        // find id from xml file
        title = (EditText) findViewById(R.id.db_title);
        author = (EditText) findViewById(R.id.db_author);
        addBtn = (Button) findViewById(R.id.db_add);
        updateBtn = (Button) findViewById(R.id.db_update);
        deleteBtn = (Button) findViewById(R.id.db_delete);
        bookListview = (ListView) findViewById(R.id.db_books_list);

        // set onClick event for each item
        addBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        bookListview.setOnItemClickListener(this);

        // update latest data from db and set it for the adapter
        updateData();
    }

    /**
     * (1) get All data from db
     * (2) set it for list
     * (3) give list for adapter
     * (4) set adapter for ListView
     */
    public void updateData() {
        bookList = db.getAllBooks();
        List<Integer> idList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        List<String> authorList = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++) {
            idList.add(i, bookList.get(i).getId());
            titleList.add(i, bookList.get(i).getTitle());
            authorList.add(i, bookList.get(i).getAuthor());
        }

        bookAdapter = new BookAdapter(this, idList, titleList, authorList);
        bookListview.setAdapter(bookAdapter);
    }

    /**
     * onClick event for 3 buttons
     * @param view which item you clicked
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.db_add:
                db.addBook(new Book(title.getText().toString(), author.getText().toString()));
                updateData();
                break;
            case R.id.db_update:
                break;
            case R.id.db_delete:
                db.delete();
                break;
        }
    }

    /**
     * clicked event for list view item
     * @see AdapterView#getOnItemClickListener#onItemClick
     * @param parent The AdapterView where the click happened.
     * @param view  The view within the AdapterView that was clicked(this will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // get view from current view
        TextView titleTextView = (TextView)view.findViewById(R.id.db_book_titl_list);
        String titleString = titleTextView.getText().toString();
        TextView authorTextView = (TextView)view.findViewById(R.id.db_book_author_list);
        String authorString = authorTextView.getText().toString();

        // set Text to current title,author EditText area
        title.setText(titleString);
        author.setText(authorString);
    }
}
