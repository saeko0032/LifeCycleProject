package com.example.ciccc_cirac.lifecycleproject;

/**
 * Created by saeko on 7/18/2017.
 */

public class Movie {
    private String title;
    private String genere;
    private String year;

    Movie(String title, String genere, String year){
        this.title = title;
        this.genere = genere;
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRate(String rate) {
        this.genere = genere;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getTitle() { return this.title; }
    public String getGenere() { return this.genere; }
    public String getYear() { return this.year; }
}
