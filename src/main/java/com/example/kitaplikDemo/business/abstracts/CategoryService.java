package com.example.kitaplikDemo.business.abstracts;

import java.util.List;

import com.example.kitaplikDemo.core.Result.DataResult;
import com.example.kitaplikDemo.core.Result.Result;
import com.example.kitaplikDemo.dto.requests.categoryRequests.CreateCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.DeleteCategoryRequests;
import com.example.kitaplikDemo.dto.requests.categoryRequests.UpdateCategoryRequests;
import com.example.kitaplikDemo.dto.responses.category.GetAllCategoryResponses;
import com.example.kitaplikDemo.model.Category;

public interface CategoryService {

    DataResult<List<GetAllCategoryResponses>> getAllCategories();

    DataResult<Category> getOneCategory(Long categoryId);

    Result add(CreateCategoryRequests createCategoryRequests);

    Result delete(DeleteCategoryRequests deleteCategoryRequests);

    Result update(UpdateCategoryRequests updateCategoryRequests);
}
