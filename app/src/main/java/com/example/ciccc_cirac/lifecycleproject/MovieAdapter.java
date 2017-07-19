package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        TextView movieGenreView;
        TextView movieYearView;
        ImageView movieImageView;

        MoviewNumberViewHolder(View itemViews) {
            super(itemViews);
            movieImageView = (ImageView) itemView.findViewById(R.id.movie_image_imageview);
            moviewTileView = (TextView) itemView.findViewById(R.id.movie_title_textview);
            movieGenreView = (TextView) itemView.findViewById(R.id.movie_genre_textview);
            movieYearView = (TextView) itemView.findViewById(R.id.movie_years_textView);
        }
        public void bind(int listIndex) {
            movieImageView.setImageResource(movie_list.get(listIndex).getImgSrc());
            moviewTileView.setText(String.valueOf(movie_list.get(listIndex).getTitle()));
            movieGenreView.setText(String.valueOf(movie_list.get(listIndex).getGenre()));
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
