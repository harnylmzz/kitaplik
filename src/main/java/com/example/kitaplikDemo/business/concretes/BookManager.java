package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.Result.DataResult;
import com.example.kitaplikDemo.dto.requests.BookRequests.CreateBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.DeleteBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.responses.Book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;
import com.example.kitaplikDemo.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

    private BookRepository bookRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllBookResponses>> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        List<GetAllBookResponses> getAllBookResponses = books.stream()
                .map(book -> this.modelMapperService.forResponse()
                        .map(book, GetAllBookResponses.class))
                .collect(Collectors.toList());

        return new DataResult<List<GetAllBookResponses>>(getAllBookResponses, true, "All books were brought.");

    }

    @Override
    public Book getOneBook(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void add(CreateBookRequests bookRequests) {
        Book book = modelMapperService.forRequest()
                .map(bookRequests, Book.class);
        this.bookRepository.save(book);

    }

    @Override
    public void delete(DeleteBookRequests deleteBookRequests) {
        Book book = modelMapperService.forRequest()
                .map(deleteBookRequests, Book.class);
        this.bookRepository.delete(book);
    }

    @Override
    public void update(UpdateBookRequests updateBookRequests) {
        Book inDbBook = bookRepository.findById(updateBookRequests.getId()).get();
        Book book = new Book();
        book.setId(updateBookRequests.getId());
        book.setAuthorName(updateBookRequests.getAuthorName());
        book.setAuthorSurname(updateBookRequests.getAuthorSurname());
        book.setBookName(updateBookRequests.getBookName());
        book.setEditorName(updateBookRequests.getEditorName());
        book.setOriginalBookName(updateBookRequests.getOriginalBookName());
        book.setPressTime(updateBookRequests.getPressTime());
        book.setTranslatorName(updateBookRequests.getTranslatorName());

    }

}
