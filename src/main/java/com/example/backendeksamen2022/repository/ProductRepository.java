package com.example.backendeksamen2022.repository;

import com.example.backendeksamen2022.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findProductsByName(String name);
}

