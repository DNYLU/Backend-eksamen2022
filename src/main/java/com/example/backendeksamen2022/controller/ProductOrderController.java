package com.example.backendeksamen2022.controller;


import com.example.backendeksamen2022.dto.AddProductOrderDto;
import com.example.backendeksamen2022.model.ProductOrder;
import com.example.backendeksamen2022.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/productOrder")
public class ProductOrderController {

    private final ProductOrderService productOrderService;
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductOrder> addProductOrder(@RequestBody AddProductOrderDto productOrderDto) {
        ProductOrder addedProductOrder = productOrderService.addProductOrder(
                productOrderDto.getDeliveryId(),
                productOrderDto.getProductId(),
                productOrderDto.getQuantity()
        );
        return new ResponseEntity<>(addedProductOrder, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductOrder>> getAllProductOrders() {
        Iterable<ProductOrder> foundProductOrders = productOrderService.getAllProductOrders();
        return new ResponseEntity<>(foundProductOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<ProductOrder>> getProductOrdersByDeliveryId(@PathVariable Long id) {
        Iterable<ProductOrder> foundProductOrder = productOrderService.getProductOrdersByDeliveryId(id);
        return new ResponseEntity<>(foundProductOrder, HttpStatus.OK);
    }

}
