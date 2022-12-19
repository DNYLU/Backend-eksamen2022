package com.example.backendeksamen2022.repository;

import com.example.backendeksamen2022.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    public Iterable<ProductOrder> findAllByDeliveryId(Long deliveryId);
}

