package com.example.ClothesShop.service;

import com.example.ClothesShop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category createCategory(Category category);


}
