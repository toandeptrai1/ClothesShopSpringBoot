package com.example.ClothesShop.service;

import com.example.ClothesShop.model.Category;
import com.example.ClothesShop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepo;

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
}
