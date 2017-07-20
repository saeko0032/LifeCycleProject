package com.example.ciccc_cirac.lifecycleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saeko on 7/19/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviewNumberViewHolder> {
    private List<Movie> movie_list;
    private int lastPosition = -1;

    public MovieAdapter(List<Movie> movie_list) {
        this.movie_list = movie_list;
    }

    // inner class
    class MoviewNumberViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitleView;
        TextView movieGenreView;
        TextView movieYearView;
        ImageView movieImageView;

        MoviewNumberViewHolder(View itemViews) {
            super(itemViews);
            movieImageView = (ImageView) itemView.findViewById(R.id.movie_image_imageview);
            movieTitleView = (TextView) itemView.findViewById(R.id.movie_title_textview);
            movieGenreView = (TextView) itemView.findViewById(R.id.movie_genre_textview);
            movieYearView = (TextView) itemView.findViewById(R.id.movie_years_textView);
        }
        public void bind(int listIndex) {
            movieImageView.setImageResource(movie_list.get(listIndex).getImgSrc());
            movieTitleView.setText(String.valueOf(movie_list.get(listIndex).getTitle()));
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
        holder.movieImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            }
        });
        holder.movieTitleView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        holder.movieGenreView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        setAnimation(holder.itemView, position);
        setFadeAnimation(holder.itemView);
    }


    private void setAnimation(View viewToAnimate, int position) {
        Context context = viewToAnimate.getContext();
        if(position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    private void setFadeAnimation(View view) {

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);

        anim.setDuration(1000);

        view.startAnimation(anim);

    }

    @Override
    public int getItemCount() {
        return movie_list.size();
    }
}
