package com.example.backendeksamen2022.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_id")
    private Long id;

    @Column(name = "product_order_quantity", nullable = false)
    private int quantity;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
