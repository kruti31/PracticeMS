package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductsRepo;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public List<ProductDTO> getProduct() {
		return productService.getProduct();

	}

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);

	}

	@GetMapping("/getbyname/{name}")
	public ProductDTO getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);

	}
	
//	@GetMapping("/getbynameandcategory/{name}/{category}")
//	public ProductDTO getProductByNameAndCategory(@PathVariable String name,String category) {
//		return productService.getProductByNameAndCategory(name,category);
//
//	}
	
	@PostMapping("/saveProduct")
	public String insertProduct(@RequestBody ProductDTO productDTO) {
		productService.insertProduct(productDTO);
		return "Product insert Successfully";
		

	}

//	@PutMapping("/updateProduct")
//	public String updateProduct(@PathVariable Long id) {
//		productService.updateProduct(id);
//		return "Product update Successfully";
//
//	}

	@DeleteMapping("/deleteProduct")
	public void deleteProduct() {

	}
}
