package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {


    DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Iterable<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).get();
    }

    public Delivery getAllProductOrdersByDeliveryId(Long id) {
        return deliveryRepository.findById(id).get();
    }


}
