package com.example.ciccc_cirac.lifecycleproject.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ciccc_cirac.lifecycleproject.R;

/**
 * Created by saeko on 7/17/2017.
 */

// you need to extends innerclass, to access inner class ThisFile.innerclass
public class GreenAdapter1 extends RecyclerView.Adapter<GreenAdapter1.NumberViewHolder1> {
    // for list item event, we need to make interface

    final private ListItemClickListener onClickListener;
    public interface ListItemClickListener {
        void onListItemClick(int position);
    }
    private int numberOfItems;
    // constructor
    public GreenAdapter1(int numberOfItems, ListItemClickListener listener){
        // how many list item do you want to use
        // if 0 to 10 -> should return 10
        this.numberOfItems = numberOfItems;
        onClickListener = listener;
    }
    // create inner class
    class NumberViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemNumbrtView;

        public NumberViewHolder1(View itemViews) {
            super(itemViews);
            listItemNumbrtView = (TextView) itemView.findViewById(R.id.list_item_textView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }
        public void bind(int listIndex){
            listItemNumbrtView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onClickListener.onListItemClick(position);
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
