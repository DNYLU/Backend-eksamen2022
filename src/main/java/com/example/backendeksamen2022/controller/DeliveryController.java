package com.example.backendeksamen2022.controller;

import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.model.ProductOrder;
import com.example.backendeksamen2022.repository.DeliveryRepository;
import com.example.backendeksamen2022.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryService deliveryService, DeliveryRepository deliveryRepository) {
        this.deliveryService = deliveryService;
        this.deliveryRepository = deliveryRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Delivery> addDelivery(@RequestBody Delivery delivery) {
        Delivery addedDelivery = deliveryService.addDelivery(delivery);
        return new ResponseEntity<>(addedDelivery, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Delivery>> getAllDeliveries() {
        Iterable<Delivery> foundDeliveries = deliveryService.getAllDeliveries();
        return new ResponseEntity<>(foundDeliveries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Delivery foundDelivery = deliveryService.getDeliveryById(id);
        return new ResponseEntity<>(foundDelivery, HttpStatus.OK);
    }

}
