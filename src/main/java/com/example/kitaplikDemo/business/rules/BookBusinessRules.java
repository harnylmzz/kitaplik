package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookBusinessRules {

    private BookRepository bookRepository;

    public void checkIfBookNameExists(String bookName) {
        if (this.bookRepository.existsByBookName(bookName)) {
            throw new BusinessException("Book already exists.");
        }
    }

    public void checkIfAuthorNameAndAuthorSurnameExists(String authorName, String authorSurname) {
        if (this.bookRepository.existsByAuthorNameAndAuthorSurname(authorName, authorSurname)) {
            throw new BusinessException("Author already exists.");
        }
    }
}
