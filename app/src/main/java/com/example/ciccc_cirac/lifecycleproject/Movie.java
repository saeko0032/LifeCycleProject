package com.example.ciccc_cirac.lifecycleproject;

/**
 * Created by saeko on 7/18/2017.
 */

public class Movie {
    private String title;
    private String genre;
    private String year;
    private int imgSrc;
    private boolean isChecked;

    Movie(String title, String genre, String year, int imgScr){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.imgSrc = imgScr;
        this.isChecked = false;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRate(String rate) {
        this.genre = genre;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }
    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    
    public String getTitle() { return this.title; }
    public String getGenre() { return this.genre; }
    public String getYear() { return this.year; }
    public int getImgSrc() { return this.imgSrc; }
    public boolean getIsChecked() { return this.isChecked; }
}
