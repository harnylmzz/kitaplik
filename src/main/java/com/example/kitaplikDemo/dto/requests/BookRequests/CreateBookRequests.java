package com.example.kitaplikDemo.dto.requests.BookRequests;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequests {

    private String authorName;
    private String authorSurname;
    private String bookName;
    private String originalBookName;
    private LocalDateTime pressTime;
    private String editorName;
    private String translatorName;
    private String isbn;
    
}
