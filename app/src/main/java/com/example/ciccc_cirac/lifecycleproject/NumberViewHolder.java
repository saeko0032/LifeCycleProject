package com.example.ciccc_cirac.lifecycleproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by saeko on 7/17/2017.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder {
    TextView listItemTextView;
    public NumberViewHolder(View itemView) {
        super(itemView);
        listItemTextView = (TextView) itemView.findViewById(R.id.tv_item_number);
    }
    public void bind(int listIndex) {
        listItemTextView.setText(String.valueOf(listIndex));
    }
}
