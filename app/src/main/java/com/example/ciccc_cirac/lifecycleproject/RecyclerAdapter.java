package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by saeko on 7/17/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<NumberViewHolderExample> {
    private int numberOfItems;

    RecyclerAdapter(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public NumberViewHolderExample onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_number_list_item, parent, false);
        NumberViewHolderExample viewHolder = new NumberViewHolderExample(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolderExample holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.numberOfItems;
    }


}
