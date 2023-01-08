package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.exception.ResourceNotFoundException;
import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.model.Product;
import com.example.backendeksamen2022.model.ProductOrder;
import com.example.backendeksamen2022.repository.DeliveryRepository;
import com.example.backendeksamen2022.repository.ProductOrderRepository;
import com.example.backendeksamen2022.repository.ProductRepository;
import org.springframework.stereotype.Service;


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
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        ProductOrder productOrder = new ProductOrder();
        productOrder.setDelivery(delivery);
        productOrder.setProduct(product);
        productOrder.setQuantity(quantity);

        delivery.setTotalWeight(delivery.getTotalWeight() + (product.getWeight() * quantity));
        delivery.setTotalPrice(delivery.getTotalPrice() + (product.getPrice() * quantity));
        deliveryRepository.save(delivery);
        return productOrderRepository.save(productOrder);
    }

    public Iterable<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    public Iterable<ProductOrder> getProductOrdersByDeliveryId(Long deliveryId) {
        return productOrderRepository.findAllByDeliveryId(deliveryId);
    }

}
