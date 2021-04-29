package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductsRepo;

@Service
public class ProductService {

	@Autowired
	ProductsRepo productrepo;

	public List<ProductDTO> getProduct() {
		return productrepo.findAll().stream().map(product -> {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
		}).collect(Collectors.toList());
	}

	public ProductDTO getProductById(@PathVariable Long id) {
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(productrepo.findById(id).get(), productDTO);
		return productDTO;
//		Optional<Product> product = productrepo.findById(id);
//		if (product.isPresent()) {
//BeanUtils.copyProperties(product, productDTO);
//return new ResponseEntity(productDTO.equals())
//		}

	}

	public ProductDTO getProductByName(String name) {
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(productrepo.findByNameLikeIgnoreCase(name).get(), productDTO);
		return productDTO;
	}

	public void insertProduct(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		productrepo.save(product);
	}

//	public void updateProduct(Long id) {
//	productrepo.updateProduct(id);
//		
//	}

//	public ProductDTO getProductByNameAndCategory(String name,String category) {
//		ProductDTO productDTO = new ProductDTO();
//		BeanUtils.copyProperties(productrepo.findByNameAndCategory(name,category).get(), productDTO);
//		return productDTO;
//	}

}
