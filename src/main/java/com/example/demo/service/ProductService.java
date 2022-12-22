package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAll(){
    return productRepository.findAll();
  }

  public Product save(Product product) {
    product.setName("name1");
    product.setUuid(UUID.randomUUID());
    product.setPrice(12);
    product.setCreatedAt(LocalDateTime.now());
    return productRepository.save(product);
  }
}
