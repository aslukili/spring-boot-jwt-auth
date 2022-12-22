package com.example.demo.rest;


import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductResource {

  private final ProductService productService;

  @Autowired
  public ProductResource(ProductService productService) {
    this.productService = productService;
  }


  @GetMapping("")
  @PreAuthorize("hasAnyRole('ROLE_STOCK', 'ROLE_CLIENT')")
  public List<Product> getAllProducts(){
    return productService.getAll();
  }

  @PostMapping("")
  @PreAuthorize("hasRole('ROLE_STOCK')")
  public Product save(@RequestBody Product product){
    return productService.save(product);
  }
}
