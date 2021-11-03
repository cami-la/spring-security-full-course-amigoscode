package com.example.demo.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;

}
