package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.LanguageRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LanguageBusinessRules {

    private LanguageRepository languageRepository;

    public void checkIfLanguageName(String language) {
        if (this.languageRepository.existsByLanguage(language)) {
            throw new BusinessException("Language already exists.");
        }
    }

}
