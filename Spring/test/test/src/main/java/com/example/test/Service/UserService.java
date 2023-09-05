package com.example.test.Service;

import com.example.test.DTO.Response.UserResponse;
import com.example.test.DTO.UserRequest;
import com.example.test.Entity.Users;

public interface UserService {
    void saveUsers(UserRequest userRequest);
    void deleteUsers(Long id);

    UserResponse loginFunction(UserRequest userRequest);
}
