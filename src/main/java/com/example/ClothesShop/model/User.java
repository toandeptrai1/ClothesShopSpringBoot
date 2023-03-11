package com.example.ClothesShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private String email;
    private String address;

    private String phone;

    private Instant created_at;
    private Instant delete_at;
    private Instant update_at;



}
