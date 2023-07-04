package com.example.kitaplikDemo.dto.requests.categoryRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequests {
    
    private Long id;
    private String categoryName;
}
