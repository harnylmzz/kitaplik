package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.BookRequests.CreateBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.DeleteBookRequests;
import com.example.kitaplikDemo.dto.requests.BookRequests.UpdateBookRequests;
import com.example.kitaplikDemo.dto.responses.Book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;

public interface BookService {

    DataResult<List<GetAllBookResponses>> getAllBooks();
    DataResult<Book> getOneBook(Long bookId);
    Result add(CreateBookRequests bookRequests);
    Result delete(DeleteBookRequests deleteBookRequests);
    Result update(UpdateBookRequests updateBookRequests);
}
