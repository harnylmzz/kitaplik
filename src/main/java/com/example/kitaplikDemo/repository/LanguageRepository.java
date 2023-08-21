package com.example.kitaplikDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kitaplikDemo.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    boolean existsByLanguage(String language);
    
}
