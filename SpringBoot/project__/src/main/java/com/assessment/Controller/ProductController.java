package com.assessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.Entity.Product;
import com.assessment.Repository.ProductRepository;
import com.assessment.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
    private ProductService productService;

	@Autowired
    private ProductRepository productRepository;

    
	@PostMapping("/create") 
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("Product created successfully");
    }
	
    @GetMapping("/get/{productId}")
    public Product getProductById(@PathVariable long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    
    @GetMapping("/products/priceGreaterThan")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@RequestParam double price) {
    	List<Product> products = productService.getProductsByPriceGreaterThan(price);
    	return ResponseEntity.ok(products);
        		
    }
    
    @GetMapping("/priceBetween")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam double minPrice,@RequestParam double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }
}
