package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookQuantity;
import com.example.ung_dung_muon_sach.service.BookQuantityService;
import com.example.ung_dung_muon_sach.service.BookService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookQuantityService bookQuantityService;

    @GetMapping("/list")
    public String getList(Model model, @PageableDefault(size = 3) Pageable pageable, Optional<String> search_name) {
        if (search_name.isPresent()) {
        model.addAttribute( "books" , bookService.findByBookName(search_name.get(), pageable));
        } else {
            model.addAttribute("books", bookService.findAll(pageable));
        }
        return "book/ListBook";
    }
    @GetMapping("book/create")
    public String createBook(Model model) {
        model.addAttribute("book" , new Book());
        return "book/CreateBook";
    }

    @PostMapping("book/save")
    public String saveBook(@ModelAttribute Book book, String quantity) {
        bookService.save(quantity, book);
       return  "redirect:/list";
    }

    @GetMapping("book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/list";
    }
    @GetMapping("book/borrow/{id}")
    public String borrowBook(@PathVariable("id") int id) {
        Book book = bookService.findById(id);
        List<BookQuantity> bookQuantities = bookQuantityService.findByBook(book);
        bookQuantities.removeIf(bookQuantity -> !bookQuantity.isBookStatus());
        bookQuantities.get(0).setBookStatus(false);
        bookQuantityService.save(bookQuantities.get(0));
        return "redirect:/list";
    }

}
