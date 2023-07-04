package com.example.kitaplikDemo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.kitaplikDemo.business.abstracts.CategoryService;
import com.example.kitaplikDemo.config.modelmapper.ModelMapperService;
import com.example.kitaplikDemo.core.result.DataResult;
import com.example.kitaplikDemo.core.result.Result;
import com.example.kitaplikDemo.core.result.SuccessResult;
import com.example.kitaplikDemo.dto.requests.categoryRequests.CreateCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.DeleteCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.UpdateCategoryRequests;
import com.example.kitaplikDemo.dto.responses.category.GetAllCategoryResponses;
import com.example.kitaplikDemo.model.Category;
import com.example.kitaplikDemo.repository.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCategoryResponses>> getAllCategories() {
       List<Category> categories = categoryRepository.findAll();
       List<GetAllCategoryResponses> getAllCategoryResponses = categories.stream()
       .map(category -> this.modelMapperService.forResponse()
       .map(category, GetAllCategoryResponses.class))
       .collect(Collectors.toList());
       
       return new DataResult<List<GetAllCategoryResponses>>(getAllCategoryResponses, true, "All categories were brought.");
    }

    @Override
    public DataResult<Category> getOneCategory(Long bookId) {
        Category category = categoryRepository.findById(bookId).orElse(null);
        return new DataResult<Category>(category, true, "Category brought."); //TODO: exception eklenecek
    }

    @Override
    public Result add(CreateCategoryRequests createCategoryRequests) {
        Category category = modelMapperService.forRequest()
        .map(createCategoryRequests, Category.class);
        this.categoryRepository.save(category);
        
        return new SuccessResult("New category added.");
    }

    @Override
    public Result delete(DeleteCategoryRequests deleteCategoryRequests) {
        Category category = modelMapperService.forRequest()
        .map(deleteCategoryRequests, Category.class);
        this.categoryRepository.delete(category);

        return new SuccessResult("The category deleted.");
    }

    @Override
    public Result update(UpdateCategoryRequests updateCategoryRequests) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
