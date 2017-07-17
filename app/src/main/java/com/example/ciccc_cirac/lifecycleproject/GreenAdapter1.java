package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by saeko on 7/17/2017.
 */

// you need to extends innerclass, to access inner class ThisFile.innerclass
public class GreenAdapter1 extends RecyclerView.Adapter<GreenAdapter1.NumberViewHolder1> {

    private int numberOfItems;
    // constructor
    public GreenAdapter1(int numberOfItems){
        // how many list item do you want to use
        // if 0 to 10 -> should return 10
        this.numberOfItems = numberOfItems;
    }
    // create inner class
    class NumberViewHolder1 extends RecyclerView.ViewHolder {
        TextView listItemNumbrtView;
        NumberViewHolder1(View itemViews) {
            super(itemViews);
            listItemNumbrtView = (TextView) itemView.findViewById(R.id.list_item_textView);
        }
        public void bind(int listIndex){
            listItemNumbrtView.setText(String.valueOf(listIndex));
        }
    }

    @Override
    public NumberViewHolder1 onCreateViewHolder(ViewGroup parent, int viewItems){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.number_list_item, parent, false);
        NumberViewHolder1 viewHolder1 = new NumberViewHolder1(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder1 holder, int position) {
        holder.bind(position);
    }

   @Override
    public int getItemCount() {
       return numberOfItems;
   }

}
