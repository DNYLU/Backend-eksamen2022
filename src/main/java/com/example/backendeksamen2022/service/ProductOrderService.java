package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.model.Product;
import com.example.backendeksamen2022.model.ProductOrder;
import com.example.backendeksamen2022.repository.DeliveryRepository;
import com.example.backendeksamen2022.repository.ProductOrderRepository;
import com.example.backendeksamen2022.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class ProductOrderService {

    DeliveryRepository deliveryRepository;
    ProductRepository productRepository;
    ProductOrderRepository productOrderRepository;

    public ProductOrderService(DeliveryRepository deliveryRepository, ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrder addProductOrder(Long deliveryId, Long productId, int quantity) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResolutionException("Delivery not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResolutionException("Product not found"));

        ProductOrder productOrder = new ProductOrder();
        productOrder.setDelivery(delivery);
        productOrder.setProduct(product);
        productOrder.setQuantity(quantity);


        return productOrderRepository.save(productOrder);
    }

    public Iterable<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    public Iterable<ProductOrder> getProductOrdersByDeliveryId(Long deliveryId) {
        return productOrderRepository.findAllByDeliveryId(deliveryId);
    }

}
