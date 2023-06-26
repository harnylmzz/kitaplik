package com.example.kitaplikDemo.dto.responses.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookResponses {

    private Long id;
    private String bookName;
    private String authorName;
    private String authorSurname;
    
}
