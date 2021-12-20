package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookQuantity;
import com.example.ung_dung_muon_sach.repository.BookQuantityRepository;
import com.example.ung_dung_muon_sach.repository.BookRepository;
import com.example.ung_dung_muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookQuantityRepository bookQuantityRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        Page<Book> bookPage = bookRepository.findAll(pageable);
        for (Book book : bookPage) {
            book.getBookQuantities().removeIf(bookQuantity -> !bookQuantity.isBookStatus());
        }
        return bookPage;
    }

    @Override
    public Page<Book> findByBookName(String bookName, Pageable pageable) {
        return bookRepository.findByBookNameContaining(bookName, pageable);
    }

    @Override
    public void save(String quantity, Book book) {
        bookRepository.save(book);
        for (int i=0; i<Integer.parseInt(quantity); i++ ) {
            Random random = new Random();
            long rd = 100 + random.nextInt(100);
            BookQuantity bookQuantity = new BookQuantity(rd,true, book);
            bookQuantityRepository.save(bookQuantity);
        }
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
