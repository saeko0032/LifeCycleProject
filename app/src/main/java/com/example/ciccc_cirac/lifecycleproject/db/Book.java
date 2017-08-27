package com.example.ciccc_cirac.lifecycleproject.db;

/**
 * Book Model Object
 * @author saeko
 */
public class Book {
    private int id;
    private String title;
    private String author;

    /**
     * Constructor with no params
     */
    public Book() {
    }

    /**
     * Constructor with params
     * @param title title of book
     * @param author author of book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     *  get title of book
     * @return title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title of book
     * @param title title of book
     */
    public void setTitle(String title) {

        this.title = title;
    }

    /**
     * get author of book
     * @return author of book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * set author of book
     * @param author author of book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get id of book
     * @return id id of book
     */
    public int getId(){
            return id;
    }

    /**
     * set id of book
     * !! don't set id by manually !!
     * @param id id of book
     */
    public void setId(int id) {
        this.id = id;
    }
}
