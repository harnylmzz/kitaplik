package com.example.kitaplikDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kitaplikDemo.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

        boolean existsByBookName(String bookName);
        boolean existsByAuthorNameAndAuthorSurname(String authorName, String authorSurname);
        List<Book> findByBookNameStartingWith(String bookName);
        List<Book> findByAuthorNameStartingWith(String authorName);
        

}
