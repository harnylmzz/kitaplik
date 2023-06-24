package com.example.kitaplikDemo.dto.requests;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequests {

    private String authorName;
    private String authorSurname;
    private String bookName;
    private String originalBookName;
    private LocalDateTime pressTime;
    private String editorName;
    private String translator_name;
    private String isbn;
    
}
