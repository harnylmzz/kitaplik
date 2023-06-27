package com.example.kitaplikDemo.dto.requests.UserRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequests {
    
    private Long id;
    private String userName;
    private String password;
}
