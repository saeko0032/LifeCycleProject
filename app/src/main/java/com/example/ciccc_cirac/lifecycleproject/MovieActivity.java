package com.example.ciccc_cirac.lifecycleproject;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by saeko on 7/18/2017.
 */

public class MovieActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    List<Movie> movieList = new ArrayList<>();
    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private Button clearBtn;
    private Button selectBtn;
    private Button deleteBtn;
    private String jsonURL = "http://192.168.13.2/kamban/moviedata.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_movie);

       // prepareMovieData();
        recyclerView = (RecyclerView) findViewById(R.id.movie_recycle_view);
        recyclerView.setHasFixedSize(true);
        clearBtn = (Button) findViewById(R.id.clear_btn_movie);
        selectBtn = (Button) findViewById(R.id.select_btn_movie);
        deleteBtn = (Button) findViewById(R.id.delete_btn_movie);

        // change checkbox's status
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Movie movie : movieList) {
                    movie.setIsChecked(false);
                }
                // we need to tell it to adapter
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        // change checkbox's status
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Movie movie : movieList) {
                    movie.setIsChecked(true);
                }

                // we need to tell it to adapter
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        // check movi_list_ischecked status -> if checked delete and refresh it
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = movieList.size() - 1; i >= 0; i--) {
                    if (movieList.get(i).getIsChecked()) {
                        movieList.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        LinearLayoutManager linearMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearMng);
        adapter = new MovieAdapter(movieList);
        //recyclerView.setAdapter(adapter);
        loadJsonData();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            adapter.notifyDataSetChanged();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            adapter.notifyDataSetChanged();
        }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

    public void loadJsonData() {
        JsonArrayRequest req = new JsonArrayRequest(jsonURL,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                try {
                    Movie movieData = null;
                    for (int i = 0; i < response.length(); i++) {
                        movieData = new Movie();
                        JSONObject movie = (JSONObject) response.get(i);
                        String title = movie.getString("title");
                        String genre = movie.getString("genre");
                        String year = movie.getString("year");
                        movieData.setTitle(title);
                        movieData.setYear(year);
                        movieData.setGenre(genre);
                        movieList.add(movieData);
                    }
                    adapter = new MovieAdapter(movieList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(req);
    }
/*
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
*/
}
