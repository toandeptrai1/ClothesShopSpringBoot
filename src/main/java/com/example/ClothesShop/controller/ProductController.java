package com.example.ClothesShop.controller;

import com.example.ClothesShop.dto.ApiResponse;
import com.example.ClothesShop.dto.ProductRequest;
import com.example.ClothesShop.model.Product;
import com.example.ClothesShop.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = {"Authorization", "Content-Type"}, exposedHeaders = {"Authorization"}, allowCredentials = "true", maxAge = 3600)
public class ProductController {
    private final ProductServiceImpl productService;
    @PostMapping
    public ResponseEntity<ApiResponse> getAllProduct(@RequestBody ProductRequest productRequest){

        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",productService.getAllProduct(productRequest.getPage(), productRequest.getSize(), productRequest.getProductName())))
                .build();

        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/by-category")
    public ResponseEntity<ApiResponse> getProductByCategory(@RequestBody ProductRequest productRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",productService.getProductsByCategory(productRequest.getCategoryId(), productRequest.getPage(), productRequest.getSize())))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductId(@PathVariable Long productId){

        return ResponseEntity.ok().body(productService.getProductById(productId));
    }
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){

        return ResponseEntity.ok().body(productService.createProduct(productRequest));
    }



}
