package com.example.kitaplikDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kitaplikDemo.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
