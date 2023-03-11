package com.example.ClothesShop.controller;

import com.example.ClothesShop.dto.UserRequest;
import com.example.ClothesShop.model.User;
import com.example.ClothesShop.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = {"Authorization", "Content-Type"}, exposedHeaders = {"Authorization"}, allowCredentials = "true", maxAge = 3600)
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<User> login(@RequestBody UserRequest userRequest){

        return ResponseEntity.ok().body(userService.login(userRequest));
    }
    @PostMapping("/signUp")
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok().body(userService.create(user));
    }

}
