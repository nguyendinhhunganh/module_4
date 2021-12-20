package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookQuantity;

import java.util.List;

public interface BookQuantityService {
    List<BookQuantity> findByBook(Book book);
    void save(BookQuantity bookQuantity);
}
