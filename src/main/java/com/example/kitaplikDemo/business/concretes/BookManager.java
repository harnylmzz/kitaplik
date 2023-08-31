package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.business.rules.BookBusinessRules;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.exceptions.DataNotFoundException;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.core.result.SuccessResult;
import com.example.kitaplikDemo.dto.requests.bookRequests.CreateBookRequests;
import com.example.kitaplikDemo.dto.requests.bookRequests.DeleteBookRequests;
import com.example.kitaplikDemo.dto.requests.bookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.responses.book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;
import com.example.kitaplikDemo.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

    private BookRepository bookRepository;
    private ModelMapperService modelMapperService;
    private BookBusinessRules bookBusinessRules;

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
    public DataResult<Book> getOneBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException("Book not found!"));
        return new DataResult<Book>(book, true, "The book borught.");
    }

    @Override
    public Result add(CreateBookRequests createBookRequests) {

        this.bookBusinessRules.checkIfIsbn(createBookRequests.getIsbn());

        Book book = modelMapperService.forRequest()
                .map(createBookRequests, Book.class);

        this.bookRepository.save(book);
        return new SuccessResult("New book added.");

    }

    @Override
    public Result delete(DeleteBookRequests deleteBookRequests) {
        Book book = modelMapperService.forRequest()
                .map(deleteBookRequests, Book.class);
        this.bookRepository.delete(book);
        return new SuccessResult("The book deleted.");
    }

    @Override
    public Result update(UpdateBookRequests updateBookRequests) {
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
        book.setIsbn(updateBookRequests.getIsbn());
        book.setStock(updateBookRequests.getStock());

        this.bookRepository.save(book);
        return new SuccessResult("The book updated.");

    }

    public BookManager() {
    }

}
