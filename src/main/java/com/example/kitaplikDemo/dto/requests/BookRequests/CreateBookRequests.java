package com.example.kitaplikDemo.dto.requests.bookRequests;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequests {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String authorName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String authorSurname;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String bookName;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String originalBookName;

    private LocalDateTime pressTime;

    @NotNull
    private String editorName;

    @NotNull
    @Size(max = 50)
    private String translatorName;

    @NotNull
    @Size(max = 50)
    private String publisher;

    @NotNull
    @Size(max = 50)
    private String dimensions;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    private Long stock;

    @NotNull
    @Size(max = 50)
    private String skinType;

    private boolean isItRented;

    private int numberOfPages;

    private String numberOfPrints;

    private Long languageId;

    private Long categoryId;

}
