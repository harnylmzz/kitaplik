package com.example.kitaplikDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kitaplikDemo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByCategoryName(String name);

}
