package com.example.ClothesShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String desc;
    private Double price;

    private String image;
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private Category category;
    private Instant created_at;
    private Instant delete_at;
    private Instant update_at;

}
