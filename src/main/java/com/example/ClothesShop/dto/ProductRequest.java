package com.example.ClothesShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private  Long productId;
    private Integer page=0;
    private Integer size=4;
    private Long categoryId;
    private String productName;
    private String desc;
    private Double price;
    private  String image;

    private Instant created_at;
    private Instant delete_at;
    private Instant update_at;




}
