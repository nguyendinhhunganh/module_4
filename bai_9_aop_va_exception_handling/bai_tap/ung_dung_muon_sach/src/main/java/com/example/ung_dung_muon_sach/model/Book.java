package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String bookAuthor;
    @OneToMany(mappedBy = "book")
    private List<BookQuantity> bookQuantities;
    public Book(Integer bookId, String bookName, String bookAuthor, List<BookQuantity> bookQuantities) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookQuantities = bookQuantities;
    }
    public Book() {
    }
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
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

    public List<BookQuantity> getBookQuantities() {
        return bookQuantities;
    }

    public void setBookQuantities(List<BookQuantity> bookQuantities) {
        this.bookQuantities = bookQuantities;
    }
}
