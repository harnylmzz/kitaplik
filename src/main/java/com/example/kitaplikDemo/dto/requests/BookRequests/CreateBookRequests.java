package com.example.kitaplikDemo.dto.requests.bookRequests;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String authorName;

    @NotNull
    @NotBlank
    private String authorSurname;

    @NotNull
    @NotBlank
    private String bookName;

    @NotNull
    @NotBlank
    private String originalBookName;

    private LocalDateTime pressTime;

    @NotNull
    private String editorName;

    @NotNull
    private String translatorName;

    @NotNull
    private String publisher;

    @NotNull
    private String dimensions;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    private Long stock;

    @NotNull
    private String skinType;

    private boolean isItRented;

    private int numberOfPages;

    private String numberOfPrints;

    private Long categoryId;

}
