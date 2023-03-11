package com.example.ClothesShop.service;

import com.example.ClothesShop.dto.ProductRequest;
import com.example.ClothesShop.model.Category;
import com.example.ClothesShop.model.Product;
import com.example.ClothesShop.repository.CategoryRepository;
import com.example.ClothesShop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    @Override
    public Page<Product> getAllProduct(int page, int size,String productName) {
        Pageable pageable= PageRequest.of(page,size);
        if(productName!=null&&!productName.equalsIgnoreCase("")){
            return  productRepo.findByProductNameContainingIgnoreCase(productName,pageable);
        }

        return productRepo.findAll(pageable);
    }

    @Override
    public Page<Product> getProductsByCategory(long categoryId,int page,int size) {
        Category categoryFindById=categoryRepo.findById(categoryId).orElseThrow();
        Pageable pageable=PageRequest.of(page,size);
        return productRepo.findByCategory(categoryFindById,pageable);
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Category category=categoryRepo.findById(productRequest.getCategoryId()).orElseThrow();

        return productRepo.save(mapToProduct(productRequest,category));
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepo.findById(productId).orElseThrow();
    }

    private Product mapToProduct(ProductRequest productRequest,Category category){

            return Product.builder()
                    .productName(productRequest.getProductName())
                    .price(productRequest.getPrice())
                    .created_at(Instant.now())
                    .update_at(Instant.now())
                    .image(productRequest.getImage())
                    .category(category)
                    .build();

    }
}
