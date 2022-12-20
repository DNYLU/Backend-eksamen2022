package com.example.backendeksamen2022.controller;

import com.example.backendeksamen2022.model.Product;
import com.example.backendeksamen2022.repository.ProductRepository;
import com.example.backendeksamen2022.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService,
                             ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Product> addCar(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> foundProducts =  productService.getAllProducts();
        return ResponseEntity.ok(foundProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product foundProduct = productService.getProductById(id);
        return new ResponseEntity<>(foundProduct, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Iterable<Product>> getProductsByName(@PathVariable String name) {
        Iterable<Product> foundProducts = productService.getProductsByName(name);
        return ResponseEntity.ok(foundProducts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.deleteProductById(id);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product updateProduct) {
        Optional<Product> updatedProductOptional = Optional.of(productService.updateProduct(id, updateProduct));
        return new ResponseEntity<>(updatedProductOptional.get(), HttpStatus.OK);
    }

}
