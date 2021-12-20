package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Page<Book> findByBookName(String bookName, Pageable pageable);
    void save(String quantity, Book book);
    void deleteBook(int id);
    Book findById(int id);
}
