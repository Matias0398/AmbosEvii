package com.example.AmbosEvii.service;

import com.example.AmbosEvii.entity.Product;
import com.example.AmbosEvii.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product>getById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product productUpdate){
        return productRepository.findById(id).map(product -> {
            product.setName(productUpdate.getName());
            product.setDescription(productUpdate.getDescription());
            product.setPrice(productUpdate.getPrice());
            product.setUrlImage(productUpdate.getUrlImage());
            return productRepository.save(product);
        }).orElse(null);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
