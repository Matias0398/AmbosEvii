package com.example.AmbosEvii.repository;

import com.example.AmbosEvii.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
