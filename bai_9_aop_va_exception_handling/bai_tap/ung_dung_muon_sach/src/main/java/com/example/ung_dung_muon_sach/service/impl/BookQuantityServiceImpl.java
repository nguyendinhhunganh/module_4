package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookQuantity;
import com.example.ung_dung_muon_sach.repository.BookQuantityRepository;
import com.example.ung_dung_muon_sach.service.BookQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQuantityServiceImpl implements BookQuantityService {
    @Autowired
    BookQuantityRepository bookQuantityRepository;


    @Override
    public List<BookQuantity> findByBook(Book book) {
        return bookQuantityRepository.findByBook(book);
    }

    @Override
    public void save(BookQuantity bookQuantity) {
        bookQuantityRepository.save(bookQuantity);
    }
}
