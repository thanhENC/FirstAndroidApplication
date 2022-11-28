package com.k20411group03.models;

import java.sql.Blob;

public class Book {
    int bookId;
    String bookName;
    String bookAuthor;
    String bookPublisher;
    int rePrint;
    double bookPrice;
    //Blob bookImage;


    public Book(int bookId, String bookName, String bookAuthor, String bookPublisher, int rePrint, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.rePrint = rePrint;
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getRePrint() {
        return rePrint;
    }

    public void setRePrint(int rePrint) {
        this.rePrint = rePrint;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
