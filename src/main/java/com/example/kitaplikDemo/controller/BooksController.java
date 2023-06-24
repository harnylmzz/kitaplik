package com.example.kitaplikDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.dto.requests.BookRequests;
import com.example.kitaplikDemo.dto.responses.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BooksController {
    
    private BookService bookService;

    @GetMapping("/getall")
    public List<GetAllBookResponses> getAll() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getOneBook (@PathVariable Long bookId) {
        return this.bookService.getOneBook(bookId);
    }

    @PostMapping("/add")
    public Book add(@RequestBody() @Valid BookRequests bookRequests) {
        return this.bookService.add(bookRequests);
    }

}
