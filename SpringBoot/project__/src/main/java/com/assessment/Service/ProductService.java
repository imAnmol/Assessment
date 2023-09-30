package com.assessment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.Entity.Product;
import com.assessment.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;
	
	public List<Product> getProductsByPriceGreaterThan(double price) {
		return productRepository.findByPriceGreaterThan(price);
	}

	public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
		return productRepository.findByPriceBetween(minPrice, maxPrice);
	}
}
