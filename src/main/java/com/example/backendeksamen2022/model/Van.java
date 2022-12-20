package com.example.backendeksamen2022.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "van_id")
    private Long id;

    @Column(name = "van_brand", nullable = false)
    private String brand;

    @Column(name = "van_model", nullable = false)
    private String model;

    @Column(name = "van_capacity", nullable = false)
    private double capacity;

}
