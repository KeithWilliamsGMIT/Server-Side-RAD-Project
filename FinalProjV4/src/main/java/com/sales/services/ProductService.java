package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service("ProductService")
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product getProduct(long pId) {
		return (Product) productRepository.findByPId(pId);
	}
	
	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) productRepository.findAll();
	}
}
