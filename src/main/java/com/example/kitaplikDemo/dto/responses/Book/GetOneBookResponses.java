package com.example.kitaplikDemo.dto.responses.book;

import lombok.Data;

@Data
public class GetOneBookResponses {
    
    private Long id;
    private String bookName;
    private String authorName;
    private String authorSurname;
}
