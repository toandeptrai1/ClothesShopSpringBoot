package com.example.ClothesShop.repository;

import com.example.ClothesShop.model.Category;
import com.example.ClothesShop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByProductNameContainingIgnoreCase(String productName,Pageable pageable);
    Page<Product> findByCategory(Category category, Pageable pageable);
}
