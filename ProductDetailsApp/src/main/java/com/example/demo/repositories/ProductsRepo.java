package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Product;

public interface ProductsRepo extends JpaRepository<Product, Long> {


	Optional<Product> findByNameIgnoreCase(String name);

	Optional<Product> findByNameLikeIgnoreCase(String name);

//	void updateProduct(Long id);

//	Optional<Product> findByNameAndCategory(String name, String category);



}
