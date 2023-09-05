package com.example.test.DTO.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String name;
    private String staffId;
    private String designation;
    private String email;
    private String token;
  }
