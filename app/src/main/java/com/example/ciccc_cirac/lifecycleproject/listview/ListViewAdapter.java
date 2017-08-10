package com.example.ciccc_cirac.lifecycleproject.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 7/18/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;

    public ListViewAdapter(Context context) {
        this.context = context;
    }

    private int[] listImgArray = {
            R.drawable.frame, R.drawable.table, R.drawable.relative,
            R.drawable.linear,  R.drawable.list, R.drawable.grid, R.drawable.recycler
    };

    private String[] listStringArray = {
            "Frame Layout", "Table Layout", "Relative Layout",
            "Linear Layout","List View" , "Grid View", "Recycler View"
    };

    @Override
    public int getCount() {
        return listImgArray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View listView;
        TextView textView;
        ImageView imageView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            listView = inflater.inflate(R.layout.list_items_listview, null);
            textView = (TextView) listView.findViewById(R.id.list_text);
            imageView = (ImageView) listView.findViewById(R.id.list_icon);

            textView.setText(listStringArray[position]);
            imageView.setImageResource(listImgArray[position]);
        } else {
            listView = (View)view;
        }
        return listView;
    }
}
