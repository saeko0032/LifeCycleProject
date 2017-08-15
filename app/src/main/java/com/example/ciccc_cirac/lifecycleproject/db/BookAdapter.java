package com.example.ciccc_cirac.lifecycleproject.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;

import java.util.List;

/**
 * adapter class
 * get book list data
 * @author saeko
 */
public class BookAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> idList;
    private List<String> titleList;
    private List<String> authorList;
    private static LayoutInflater inflater=null;

    /**
     * Constructor with params
     * it will initialize when you set List Data
     * @param context Main Activity
     * @param idList Linked List which has book's id(id is auto-increment)
     * @param titleList Linked List which has book's title
     * @param authorList Linked List which has book's author
     */
    public BookAdapter(Context context, List<Integer> idList, List<String> titleList, List<String> authorList) {
        this.context = context;
        this.idList = idList;
        this.titleList = titleList;
        this.authorList = authorList;
        this.inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    /**
     * @see BaseAdapter#getCount()
     * @return size of the book id list that stored in db
     */
    @Override
    public int getCount() {
        return idList.size();
    }

    /**
     * @see BaseAdapter#getItem(int)
     * @param position the position in the data
     * @return position the position in the data
     */
    @Override
    public Object getItem(int position) {
        return position;
    }

    /**
     * @see BaseAdapter#getItemId(int)
     * @param position row position in the data
     * @return position row position in the data
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @see BaseAdapter#getView(int, View, ViewGroup)
     * @param position The position of the item within the adapter's data set of the item whose view we want.
     * @param convertView View that displays the data at the specified position in the data set
     * @param parent  The parent that this view will eventually be attached to
     * @return View A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView;
        TextView idView;
        TextView titleView;
        TextView authorView;

        // always need to check non-null
        if (convertView == null) {
            listView = inflater.inflate(R.layout.database_book_list, null);
            idView = (TextView) listView.findViewById(R.id.db_book_id_list);
            titleView = (TextView) listView.findViewById(R.id.db_book_titl_list);
            authorView = (TextView) listView.findViewById(R.id.db_book_author_list);

            idView.setText(Integer.toString(this.idList.get(position)));
            titleView.setText(this.titleList.get(position));
            authorView.setText(this.authorList.get(position));
        } else {
            listView = convertView;
        }
        return listView;
    }
}
