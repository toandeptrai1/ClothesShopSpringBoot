package com.example.ClothesShop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String address;

    private String phone;

    private Instant created_at;
    private Instant delete_at;
    private Instant update_at;

}
