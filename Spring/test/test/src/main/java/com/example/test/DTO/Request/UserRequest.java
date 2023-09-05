package com.example.test.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private Long id;
    private String name;
    private String staffId;
    private String designation;
    private String email;
    private String password;
}
