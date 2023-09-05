package com.example.test.Service.impl;

import com.example.test.DTO.Response.UserResponse;
import com.example.test.DTO.UserRequest;
import com.example.test.Entity.Users;
import com.example.test.Repository.UserRepository;
import com.example.test.Service.UserService;
import com.example.test.Utils.JwtUtils;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void saveUsers(UserRequest userRequest) {
        Users user = new Users();
        BeanUtils.copyProperties(userRequest,user);
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
    }

    @Override
    public void deleteUsers(Long id) {

    }

    @Override
    public UserResponse loginFunction(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        Users user = userRepository.findFirstByEmailIgnoreCaseAndPassword(userRequest.getEmail(),userRequest.getPassword());
        BeanUtils.copyProperties(user,userResponse);
        user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
        userResponse.setToken(jwtUtils.generateToken(user));
        return userResponse;

    }




}
