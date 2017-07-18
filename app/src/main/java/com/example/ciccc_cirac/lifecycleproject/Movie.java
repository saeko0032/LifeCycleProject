package com.example.ciccc_cirac.lifecycleproject;

/**
 * Created by saeko on 7/18/2017.
 */

public class Movie {
    private String title;
    private String rate;
    private int year;

    Movie(String title, String rate, int year){
        this.title = title;
        this.rate = rate;
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
