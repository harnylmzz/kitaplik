package com.example.kitaplikDemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.BookRequests.CreateBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.DeleteBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.responses.Book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("api/books")
public class BooksController {
    
    private BookService bookService;

    @GetMapping("/getall")
    public DataResult<List<GetAllBookResponses>> getAll() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public DataResult<Book> getOneBook (@PathVariable Long bookId) {
        return this.bookService.getOneBook(bookId);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody() @Valid CreateBookRequests bookRequests) {
      return this.bookService.add(bookRequests);
    }

    @DeleteMapping("/delete")
    public Result delete (DeleteBookRequests deleteBookRequests) {
       return this.bookService.delete(deleteBookRequests);
    }

    @PutMapping("/update")
    public Result update (@RequestBody UpdateBookRequests updateBookRequests) {
       return this.bookService.update(updateBookRequests);

    }

}
