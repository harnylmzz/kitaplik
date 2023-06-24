package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.dto.requests.BookRequests;
import com.example.kitaplikDemo.dto.responses.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;

public interface BookService {

    List<GetAllBookResponses> getAllBooks();
    Book getOneBook(Long bookId);
    Book add(BookRequests bookRequests);
}
