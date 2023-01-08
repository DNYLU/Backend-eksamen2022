package com.example.backendeksamen2022.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate date;

    @Column(name = "delivery_fromWarehouse", nullable = false)
    private String fromWarehouse;

    @Column(name = "delivery_destination", nullable = false)
    private String destination;

    @Column(name = "delivery_totalWeight")
    private double totalWeight;

    @Column(name = "delivery_totalPrice")
    private double totalPrice;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "van_id")
    private Van van;

}
