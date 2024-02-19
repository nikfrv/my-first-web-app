package com.example.books.MySQL;

import java.io.Serializable;
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String bookName;
    private String bookAuthor;

    public Book(){}
    public Book (String bookName, String bookAuthor){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public Book(int id, String bookName, String bookAuthor){
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getBookAuthor(){
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }
}
