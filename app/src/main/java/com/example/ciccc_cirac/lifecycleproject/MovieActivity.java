package com.example.ciccc_cirac.lifecycleproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saeko on 7/18/2017.
 */

public class MovieActivity extends AppCompatActivity {
    List<Movie> movieList;
    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_movie);

        movieList = new ArrayList<>();
        prepareMovieData();

        recyclerView = (RecyclerView) findViewById(R.id.movie_recycle_view);
        LinearLayoutManager linearMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearMng);
        adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);

    }
    public void prepareMovieData() {
        // 1
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.movie1);
        movieList.add(movie);
        // 2
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.movie2);
        movieList.add(movie);
        // 3
        movie = new Movie("The Shawshank Redemption ", "Drama", "1994", R.drawable.movie3);
        movieList.add(movie);
        // 4
        movie = new Movie("The Godfather ", "Drama", "1972", R.drawable.movie4);
        movieList.add(movie);
        // 5
        movie = new Movie("The Dark Knight", "Action & Drama", "2008", R.drawable.movie5);
        movieList.add(movie);
        // 6
        movie = new Movie("12 Angry Men ", "Cinema & Drama", "1957", R.drawable.movie6);
        movieList.add(movie);
        // 7
        movie = new Movie("Schindler's List", "Biography & History", "1993", R.drawable.movie7);
        movieList.add(movie);
        // 8
        movie = new Movie("Pulp Fiction", "Animation, Kids & Family", "1994", R.drawable.movie8);
        movieList.add(movie);
        // 9
        movie = new Movie("Fight Club", "Drama", "1999", R.drawable.movie9);
        movieList.add(movie);
        // 10
        movie = new Movie(" The Lord of the Ring", "Adventure & Fantasy", "2003", R.drawable.movie10);
        movieList.add(movie);
        // 11
        movie = new Movie("Forest Gump", "Comedy & Romance", "1994", R.drawable.movie11);
        movieList.add(movie);
    }

}
