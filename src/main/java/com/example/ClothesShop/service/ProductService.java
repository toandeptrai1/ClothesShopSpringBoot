package com.example.ClothesShop.service;

import com.example.ClothesShop.dto.ProductRequest;
import com.example.ClothesShop.model.Category;
import com.example.ClothesShop.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> getAllProduct(int page,int size,String productName);
    Page<Product> getProductsByCategory(long categoryId,int page,int size);
    Product createProduct(ProductRequest  productRequest);
    Product getProductById(Long productId);
}
