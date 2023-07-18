package com.example.kitaplikDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kitaplikDemo.business.abstracts.CategoryService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.dto.requests.categoryRequests.CreateCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.DeleteCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.UpdateCategoryRequests;
import com.example.kitaplikDemo.dto.responses.category.GetAllCategoryResponses;
import com.example.kitaplikDemo.model.Category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCategoryResponses>> getAll() {
        return this.categoryService.getAllCategories();

    }

    @GetMapping("/{categoryId}")
    public DataResult<Category> getOneCategory(@PathVariable Long categoryId) {
       return this.categoryService.getOneCategory(categoryId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCategoryRequests createCategoryRequests) {
       return this.categoryService.add(createCategoryRequests);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequests updateCategoryRequests) {
        return this.categoryService.update(updateCategoryRequests);
    }

   @DeleteMapping("/delete")
    public Result delete(DeleteCategoryRequests deleteCategoryRequests) {
        return this.categoryService.delete(deleteCategoryRequests);
    }
    
}
