package com.example.kitaplikDemo.dto.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequests {

    private String userName;
    private String password;
}
