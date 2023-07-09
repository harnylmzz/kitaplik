package com.example.kitaplikDemo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "author_name")
  private String authorName;

  @Column(name = "author_surname")
  private String authorSurname;

  @Column(name = "book_name")
  private String bookName;

  @Column(name = "original_book_name")
  private String originalBookName;

  @Column(name = "number_of_pages")
  private int numberOfPages;

  @Column(name = "number_of_prints")
  private String numberOfPrints;

  @Column(name = "skin_type")
  private String skinType;

  @Column(name = "press_time")
  private LocalDateTime pressTime;

  @Column(name = "editor_name")
  private String editorName;

  @Column(name = "translator_name")
  private String translatorName;

  @Column(name = "publisher")
  private String publisher;

  @Column(name = "dimensions")
  private String dimensions;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "stock")
  private Long stock;

  @Column(name = "is_it_rented")
  private boolean isItRented;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  @JoinColumn(name = "category_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  Category category;

}
