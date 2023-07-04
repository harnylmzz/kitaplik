package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookBusinessRules {

    private BookRepository bookRepository;

    public void checkIfIsbn(String isbn) {
        if(this.bookRepository.existsByIsbn(isbn)) {
            throw new BusinessException("Book already exists.");
        }
    }
}
