package com.example.kitaplikDemo.dto.responses.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponses {

    private Long id;
    private String userName;
    
}
