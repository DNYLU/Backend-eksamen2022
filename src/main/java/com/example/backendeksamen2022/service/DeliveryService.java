package com.example.backendeksamen2022.service;

import com.example.backendeksamen2022.exception.ResourceNotFoundException;
import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.model.Van;
import com.example.backendeksamen2022.repository.DeliveryRepository;
import com.example.backendeksamen2022.repository.VanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeliveryService {


    DeliveryRepository deliveryRepository;
    private final VanRepository vanRepository;

    public DeliveryService(DeliveryRepository deliveryRepository,
                           VanRepository vanRepository) {
        this.deliveryRepository = deliveryRepository;
        this.vanRepository = vanRepository;
    }

    public Delivery addDelivery(LocalDate date, String fromWarehouse, String destination) {
        Delivery delivery = new Delivery();
        delivery.setDate(date);
        delivery.setFromWarehouse(fromWarehouse);
        delivery.setDestination(destination);
        return deliveryRepository.save(delivery);
    }

    public Iterable<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).get();
    }


    public Delivery addDeliveryToVan(Long vanId, Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));
        Van van = vanRepository.findById(vanId)
                .orElseThrow(() -> new ResourceNotFoundException("Van not found"));

        if (delivery.getTotalWeight() > van.getCapacity()) {
            throw new ResourceNotFoundException("Van is too small");
        }if (delivery.getVan() != null) {
            throw new ResourceNotFoundException("Delivery is already assigned to a van");
        }
        else {
            delivery.setVan(van);
            return deliveryRepository.save(delivery);
        }
    }

}
