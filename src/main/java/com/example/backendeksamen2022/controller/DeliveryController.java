package com.example.backendeksamen2022.controller;

import com.example.backendeksamen2022.dto.AddDeliveryDto;
import com.example.backendeksamen2022.model.Delivery;
import com.example.backendeksamen2022.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;


    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Delivery> addDelivery(@RequestBody AddDeliveryDto deliveryDto) {
        Delivery delivery = deliveryService.addDelivery(
                deliveryDto.getDate(),
                deliveryDto.getFromWarehouse(),
                deliveryDto.getDestination()
        );
        return new ResponseEntity<>(delivery, HttpStatus.OK);
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

    @PostMapping("/add/vanId/{vanId}/deliveryId/{deliveryId}")
    public ResponseEntity<Delivery> addDeliveryToVan(@PathVariable Long vanId, @PathVariable Long deliveryId) {
        Delivery addedDeliveryToVan = deliveryService.addDeliveryToVan(vanId, deliveryId);
        return new ResponseEntity<>(addedDeliveryToVan, HttpStatus.OK);
    }
}
