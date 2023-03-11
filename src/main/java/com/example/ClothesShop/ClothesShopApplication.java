package com.example.ClothesShop;

import com.example.ClothesShop.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class ClothesShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesShopApplication.class, args);
	}

}
