package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.exception.ResourceNotFoundException;
import com.example.backendeksamen2022.model.Product;
import com.example.backendeksamen2022.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //Using Iterable instead of List, as I only need to iterate over the list
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Iterable<Product> getProductsByName(String name) {
        return productRepository.findProductsByName(name);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product deleteProductById(Long id) {
        Product deletedProduct = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return deletedProduct;
    }

    public Product updateProduct(Long id, Product updateProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }

        Product product = optionalProduct.get();
        if (updateProduct.getName() != null) {
            product.setName(updateProduct.getName());
        }
        if (updateProduct.getPrice() != 0) {
            product.setPrice(updateProduct.getPrice());
        }
        if (updateProduct.getWeight() != 0) {
            product.setWeight(updateProduct.getWeight());
        }
        return productRepository.save(product);
    }

}
