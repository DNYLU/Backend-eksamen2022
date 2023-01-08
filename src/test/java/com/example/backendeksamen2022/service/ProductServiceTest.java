package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.model.Product;
import com.example.backendeksamen2022.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    private List<Product> allProductsInDatabase;

    private Product createTestProduct(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("name");
        product.setPrice(100);
        product.setWeight(10);
        return product;
    }

    @BeforeAll
    public void setup() {
        Product product1 = createTestProduct(1L);
        Product product2 = createTestProduct(2L);
        Product product3 = createTestProduct(3L);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }

    @Test
    @Order(1)
    @DisplayName("Test retrieving all products")
    public void testRetrieveProductsFromDatabase() {
        allProductsInDatabase = productRepository.findAll();
        assertEquals(3, allProductsInDatabase.size(), "The list size should be 3 products"); //Message is optional
    }

    @Test
    @Order(2)
    @DisplayName("Test creating a new product")
    public void testAddNewProduct(){
        Product newProduct = createTestProduct(null);
        Product addedProduct = productService.addProduct(newProduct);
        assertNotNull(addedProduct, "The added product should not be null");
        assertEquals(newProduct.getName(), addedProduct.getName(), "The name should be the same");
        assertEquals(newProduct.getPrice(), addedProduct.getPrice(), "The price should be the same");
        assertEquals(newProduct.getWeight(), addedProduct.getWeight(), "The weight should be the same");
    }

    @Test
    @Order(3)
    @DisplayName("Test retrieving a product by name")
    public void testRetrieveProductByName() {
        List<Product> foundProducts = (List<Product>) productService.getProductsByName("name");
        assertNotNull(foundProducts, "The product should not be null");
        assertEquals("name", foundProducts.get(0).getName(), "The name should be the same");
        assertEquals(100, foundProducts.get(0).getPrice(), "The price should be the same");
        assertEquals(10, foundProducts.get(0).getWeight(), "The weight should be the same");
    }

    @Test
    @Order(4)
    @DisplayName("Test deleting a product by id")
    public void testDeleteProductById() {
        productService.deleteProductById(4L);
        List<Product> foundProducts = (List<Product>) productService.getProductsByName("name");
        assertEquals(3, foundProducts.size(), "The list size should be 2 products");
    }

    @Test
    @Order(5)
    @DisplayName("Test updating a product by id")
    public void testUpdateProductById() {
        Product product = productService.getProductById(2L);
        product.setName("new name");
        product.setPrice(999);
        product.setWeight(99);
        Product updatedProduct = productService.updateProduct(2L, product);
        assertNotNull(updatedProduct, "The updated product should not be null");
        assertEquals("new name", updatedProduct.getName(), "The name should be the same");
        assertEquals(999, updatedProduct.getPrice(), "The price should be the same");
        assertEquals(99, updatedProduct.getWeight(), "The weight should be the same");
    }

}
