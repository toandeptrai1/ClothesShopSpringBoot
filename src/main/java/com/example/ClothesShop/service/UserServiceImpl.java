package com.example.ClothesShop.service;

import com.example.ClothesShop.dto.UserRequest;
import com.example.ClothesShop.model.User;
import com.example.ClothesShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    @Override
    public User login(UserRequest userRequest) {

        return userRepo.findByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }
}
