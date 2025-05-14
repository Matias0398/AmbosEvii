package com.example.AmbosEvii.controller;

import com.example.AmbosEvii.entity.Product;
import com.example.AmbosEvii.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> productList(){
        return productService.getAll();
    }

    @GetMapping
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return productService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Product saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.update(id, product);
        if(updatedProduct != null){
            return ResponseEntity.ok(updatedProduct);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
