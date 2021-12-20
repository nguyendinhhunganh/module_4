package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByBookNameContaining(String bookName, Pageable pageable);
}
