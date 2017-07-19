package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saeko on 7/19/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviewNumberViewHolder> {
    private List<Movie> movie_list;

    public MovieAdapter(List<Movie> movie_list) {
        this.movie_list = movie_list;
    }

    // inner class
    class MoviewNumberViewHolder extends RecyclerView.ViewHolder {
        TextView moviewTileView;
        TextView movieGenereView;
        TextView movieYearView;

        MoviewNumberViewHolder(View itemViews) {
            super(itemViews);
            moviewTileView = (TextView) itemView.findViewById(R.id.movie_title_textview);
            movieGenereView = (TextView) itemView.findViewById(R.id.movie_genere_textview);
            movieYearView = (TextView) itemView.findViewById(R.id.movie_years_textView);
        }
        public void bind(int listIndex) {
            moviewTileView.setText(String.valueOf(movie_list.get(listIndex).getTitle()));
            movieGenereView.setText(String.valueOf(movie_list.get(listIndex).getGenere()));
            movieYearView.setText(String.valueOf(movie_list.get(listIndex).getYear()));
        }
    }

    @Override
    public MoviewNumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list_row, parent, false);
        MoviewNumberViewHolder viewHolder = new MoviewNumberViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviewNumberViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return movie_list.size();
    }
}
