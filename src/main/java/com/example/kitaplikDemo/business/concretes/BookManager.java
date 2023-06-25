package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.dto.requests.BookRequests;
import com.example.kitaplikDemo.dto.responses.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;
import com.example.kitaplikDemo.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

    private BookRepository bookRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBookResponses> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        List<GetAllBookResponses> getAllBookResponses = books.stream()
        .map(book -> this.modelMapperService.forResponse()
        .map(book, GetAllBookResponses.class))
        .collect(Collectors.toList());

        return getAllBookResponses;
        
    }

    @Override
    public Book getOneBook(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void add(BookRequests bookRequests) {
        Book book = modelMapperService.forRequest()
        .map(bookRequests, Book.class);
        this.bookRepository.save(book);
        
    }

}
