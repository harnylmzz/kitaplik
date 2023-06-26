package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.dto.requests.BookRequests.CreateBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.DeleteBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.responses.Book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;

public interface BookService {

    List<GetAllBookResponses> getAllBooks();
    Book getOneBook(Long bookId);
    void add(CreateBookRequests bookRequests);
    void delete(DeleteBookRequests deleteBookRequests);
    void update(UpdateBookRequests updateBookRequests);
}
