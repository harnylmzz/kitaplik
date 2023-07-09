package com.example.kitaplikDemo.dto.responses.language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponses {

    private Long id;
    private String language;
}
