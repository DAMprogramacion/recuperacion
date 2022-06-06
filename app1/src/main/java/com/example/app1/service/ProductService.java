package com.example.app1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app1.entity.Product;

@Service
public interface ProductService {
	
	List<Product> findAll();
	public Optional< Product > findById(int id);
	Product save(Product product);
	void deleteById(int id);
	
}
