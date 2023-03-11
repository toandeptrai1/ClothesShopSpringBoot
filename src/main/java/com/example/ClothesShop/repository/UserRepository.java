package com.example.ClothesShop.repository;

import com.example.ClothesShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserNameAndPassword(String userName,String password);

}
