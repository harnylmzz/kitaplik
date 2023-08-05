package com.example.kitaplikDemo.business.concretes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.kitaplikDemo.business.abstracts.BookService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.dto.responses.book.GetAllBookResponses;
import com.example.kitaplikDemo.model.Book;
import com.example.kitaplikDemo.repository.BookRepository;

@ExtendWith(MockitoExtension.class) // mockito'yu junit ile entegre etmeye yarıyor
public class BookManagerTest {

        @Mock
        private BookRepository bookRepository;

        @Mock
        private ModelMapperService modelMapperService;

        @InjectMocks
        private BookService bookService = new BookManager(); // BookManager nesnesini burada oluşturuyoruz.

        @DisplayName("Test the getAllBooks method")
        @Test
        public void testGetAllBooks() {

                List<Book> mockBooks = Arrays.asList(
                                new Book(null, null, null, null, null, 1, "Book 1", null, null, null, null, null, null,
                                                null, null,
                                                false, null, null),
                                new Book(null, null, null, null, null, 2, "Book 2", null, null, null, null, null, null,
                                                null, null,
                                                false, null, null),
                                new Book(null, null, null, null, null, 3, "Book 3", null, null, null, null, null, null,
                                                null, null,
                                                false, null, null));

                when(bookRepository.findAll()).thenReturn(mockBooks);
                Mockito.when(modelMapperService.forResponse()).thenReturn(new ModelMapper());

                DataResult<List<GetAllBookResponses>> result = bookService.getAllBooks();

                assertTrue(result.isSuccess());
                assertEquals("All books were brought.", result.getMessage());

                List<GetAllBookResponses> responses = result.getData();
                assertEquals(3, responses.size());

                verify(bookRepository, times(1)).findAll();

        }
}
