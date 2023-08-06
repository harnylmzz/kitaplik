package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.LanguageRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LanguageBusinessRules {

    private LanguageRepository languageRepository;

    public void checkIfLanguageName(String name) {
        if (this.languageRepository.existsByLanguageName(name)) {
            throw new BusinessException("Language already exists.");
        }
    }

}
