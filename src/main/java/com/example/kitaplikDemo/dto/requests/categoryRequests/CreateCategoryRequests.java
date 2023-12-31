package com.example.kitaplikDemo.dto.requests.categoryRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequests {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String categoryName;

}
