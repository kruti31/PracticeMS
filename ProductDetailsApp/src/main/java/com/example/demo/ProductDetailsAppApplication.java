package com.example.demo;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductsRepo;

@SpringBootApplication
public class ProductDetailsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsAppApplication.class, args);
	}
	
	@Autowired
	ProductsRepo productRepo;
	
	@PostConstruct
	public void insertData() {
		
		productRepo.save(new Product("Samsung 788","Electronics",10000.00,new Date()));
		
		productRepo.save(new Product("Sanitizer","Hygienic Health",100.00,new Date()));
	}

}
