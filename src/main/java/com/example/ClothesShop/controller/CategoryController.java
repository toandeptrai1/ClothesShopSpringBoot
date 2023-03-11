package com.example.ClothesShop.controller;

import com.example.ClothesShop.model.Category;
import com.example.ClothesShop.service.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok().body(categoryService.getCategories());
    }
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        category.setCreated_at(Instant.now());
        return ResponseEntity.ok().body(categoryService.createCategory(category));
    }

}
