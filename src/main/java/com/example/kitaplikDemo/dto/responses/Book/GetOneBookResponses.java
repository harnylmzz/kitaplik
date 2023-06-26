package com.example.kitaplikDemo.dto.responses.Book;

import lombok.Data;

@Data
public class GetOneBookResponses {
    
    private Long id;
    private String bookName;
    private String authorName;
    private String authorSurname;
}
