package com.example.ciccc_cirac.lifecycleproject.db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
    Button sortByTitleBtn;
    Button sortByAuthorBtn;
    ListView bookListView;
    BookAdapter bookAdapter;
    List<Book> bookList;
    static int selectedBookID;
    static int tappedPosition;
    static int selectedOrderType;
    public static final int TYPE_WITHOUT_SORT = 0;
    public static final int TYPE_ORDER_BY_TITLE = 1;
    public static final int TYPE_ORDER_BY_AUTHOR = 2;
    // make list to adapter change
    List<Integer> idList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> authorList = new ArrayList<>();


    /**
     * set xml file data and update all db data and set it for the adapter
     * @see AppCompatActivity#onCreate
     * @param savedInstanceState original instance
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
        sortByTitleBtn = (Button) findViewById(R.id.db_sort_title);
        sortByAuthorBtn = (Button) findViewById(R.id.db_sort_author);
        bookListView = (ListView) findViewById(R.id.db_books_list);

        // set onClick event for each item
        addBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        sortByTitleBtn.setOnClickListener(this);
        sortByAuthorBtn.setOnClickListener(this);
        bookListView.setOnItemClickListener(this);

        selectedOrderType = TYPE_WITHOUT_SORT;

        // update latest data from db and set it for the adapter
        updateData(TYPE_WITHOUT_SORT);
    }

    /**
     * (1) get All data from db
     * (2) set it for list
     * (3) give list for adapter
     * (4) set adapter for ListView
     */
    public void updateData(int type) {
        //selectedOrderType = type;
        bookList = db.getAllBooks(type);

        if(bookAdapter != null) {
            // change data order to list
            idList.clear();
            titleList.clear();
            authorList.clear();

            for (int i = 0; i < bookList.size(); i++) {
                idList.add(i, bookList.get(i).getId());
                titleList.add(i, bookList.get(i).getTitle());
                authorList.add(i, bookList.get(i).getAuthor());
            }
        } else {
            // create new list
            for (int i = 0; i < bookList.size(); i++) {
                idList.add(i, bookList.get(i).getId());
                titleList.add(i, bookList.get(i).getTitle());
                authorList.add(i, bookList.get(i).getAuthor());
            }
            bookAdapter = new BookAdapter(this, idList, titleList, authorList);
            bookListView.setAdapter(bookAdapter);
        }
    }

    /**
     * onClick event for 3 buttons
     * @param view which item you clicked
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.db_add:
                String titleStr = title.getText().toString();
                String authorStr = author.getText().toString();
                // add book object to db
                db.addBook(new Book(titleStr, authorStr));
                // add book object to list
                bookList = db.getAllBooks(selectedOrderType);
                for(Book book: bookList) {
                    if (titleStr.equals(book.getTitle())) {
                        idList.add(book.getId());
                        titleList.add(titleStr);
                        authorList.add(authorStr);
                    }
                }
                break;
            case R.id.db_update:
                Book tmpBook1 = new Book();
                tmpBook1.setId(selectedBookID);

                // we want to get the last(modified) value
                String changedTitleStr = title.getText().toString();
                String changedAuthorStr = author.getText().toString();
                tmpBook1.setTitle(changedTitleStr);
                tmpBook1.setAuthor(changedAuthorStr);

                // update selected book object to db
                db.update(tmpBook1);

                // update selected book object to list
                titleList.set(tappedPosition, changedTitleStr);
                authorList.set(tappedPosition, changedAuthorStr);
                break;
            case R.id.db_delete:
                Book tmpBook2 = new Book();
                tmpBook2.setId(selectedBookID);

                // we want to get the last(modified) value
                tmpBook2.setTitle(title.getText().toString());
                tmpBook2.setAuthor(author.getText().toString());

                // delete selected book object to db
                db.delete(tmpBook2);

                // delete selected book object to list
                idList.remove(tappedPosition);
                titleList.remove(title.getText().toString());
                authorList.remove(author.getText().toString());
                break;
            case R.id.db_sort_title:
                selectedOrderType = TYPE_ORDER_BY_TITLE;

                // change data list
                updateData(TYPE_ORDER_BY_TITLE);
                break;
            case R.id.db_sort_author:
                selectedOrderType = TYPE_ORDER_BY_AUTHOR;
                // change data list
                updateData(TYPE_ORDER_BY_AUTHOR);
                break;

        }

        // tell adapter that we changed list data
        bookAdapter.notifyDataSetChanged();
        bookListView.setAdapter(bookAdapter);
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
        tappedPosition = position;
        selectedBookID = bookList.get(position).getId();
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
