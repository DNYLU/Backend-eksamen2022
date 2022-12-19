package com.example.backendeksamen2022.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private double price; //BigDecimal is more precise as you can specify the rounding mode (rounding up or down)

    @Column(name = "product_weight", nullable = false)
    private double weight;
}
