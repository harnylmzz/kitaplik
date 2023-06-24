package com.example.kitaplikDemo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "author_name")
    private String authorName;

    @NotNull
    @NotBlank
    @Column(name = "author_surname")
    private String authorSurname;

    @NotNull
    @NotBlank
    @Lob
    @Column(name = "book_name")
    private String bookName;

    @Column(name = "original_book_name")
    private String originalBookName;

    @Column(name = "press_time")
    private LocalDateTime pressTime;

    @Column(name = "editor_name")
    private String editorName;

    @Column(name = "translator_name")
    private String translator_name;

    @NotNull
    @NotBlank
    @Column(name = "isbn")
    private String isbn;

}
