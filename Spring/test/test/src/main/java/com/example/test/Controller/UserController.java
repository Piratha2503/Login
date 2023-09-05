package com.example.test.Controller;

import com.example.test.DTO.UserRequest;
import com.example.test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUsers")
    public ResponseEntity<Object> saveUsers(@RequestBody UserRequest userRequest)
    {
        userService.saveUsers(userRequest);
        return ResponseEntity.ok("ok");

    }
    @GetMapping("/loginUsers")
    public ResponseEntity<Object> loginFunction(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.loginFunction(userRequest));
    }


}
