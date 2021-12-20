package com.example.ung_dung_muon_sach.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookQuantity {
    @Id
    private long bookQuantityId;
    private boolean bookStatus;
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookQuantity() {
    }

    public BookQuantity(long bookQuantityId, boolean bookStatus, Book book) {
        this.bookQuantityId = bookQuantityId;
        this.bookStatus = bookStatus;
        this.book = book;
    }

    public long getBookQuantityId() {
        return bookQuantityId;
    }

    public void setBookQuantityId(long bookQuantityId) {
        this.bookQuantityId = bookQuantityId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
