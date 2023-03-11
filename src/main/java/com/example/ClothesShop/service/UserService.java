package com.example.ClothesShop.service;

import com.example.ClothesShop.dto.UserRequest;
import com.example.ClothesShop.model.User;

public interface UserService {
    User login(UserRequest userRequest);

    User create(User user);

}
