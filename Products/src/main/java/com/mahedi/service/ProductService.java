package com.mahedi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahedi.entity.Product;
import com.mahedi.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product>getAllproduct(){
		return productRepository.findAll();
	}
	
	public Product updateProduct(long id) {
		Optional<Product> optional=productRepository.findById(id);
		
		Product product=optional.get();
		
		return product;
	}
	
	public void deleteProduct(long id) {
		this.productRepository.deleteById(id);
	}
}
