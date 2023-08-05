package com.example.kitaplikDemo.business.rules;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.core.exceptions.BusinessException;
import com.example.kitaplikDemo.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {

    private CategoryRepository categoryRepository;

    public void checkIfCategoryName(String name) {
        if(this.categoryRepository.existsByCategoryName(name)) {
            throw new BusinessException("Category already exists.");
        }

    }
    
}
