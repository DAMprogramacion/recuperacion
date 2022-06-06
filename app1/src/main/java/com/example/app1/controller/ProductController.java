package com.example.app1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app1.entity.Product;
import com.example.app1.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Product product){
	
		return ResponseEntity.status(HttpStatus.CREATED).
				body(productService.save(product));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable(value = "id") int idValue){
		Optional<Product> oProduct = productService.findById(idValue);
		if (!oProduct.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(oProduct);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById (@PathVariable(value = "id") int idValue){
		Optional<Product> oProduct = productService.findById(idValue);
		if (!oProduct.isPresent())
			return ResponseEntity.badRequest().build();
		productService.deleteById(idValue);
		return ResponseEntity.ok(oProduct);
		
	}
	@GetMapping
	public  ResponseEntity<?> getAllProducts( ) {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> deleteById
	(@RequestBody Product newProduct ,@PathVariable(value = "id") int idValue) {
	Optional<Product> oProduct = productService.findById(idValue);
	if (!oProduct.isPresent())
		return ResponseEntity.badRequest().build();
	oProduct.get().setName(newProduct.getName());
	oProduct.get().setPrices(newProduct.getPrices());
	return ResponseEntity.status(HttpStatus.CREATED).body(
			productService.save(oProduct.get()));
	

	
	}

}
