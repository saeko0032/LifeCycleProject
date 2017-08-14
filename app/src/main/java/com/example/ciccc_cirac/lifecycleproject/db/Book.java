package com.example.ciccc_cirac.lifecycleproject.db;

/**
 * Created by saeko on 8/14/2017.
 */

public class Book {
    private int id;
    private String title,author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Book [ " + " id : " + id + " title : " + title + " author : " + author +" ]";
    }
}
