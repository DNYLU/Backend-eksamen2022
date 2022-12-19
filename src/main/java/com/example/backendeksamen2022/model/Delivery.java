package com.example.backendeksamen2022.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "delivery_date", nullable = false)
    private Date date;

    @Column(name = "delivery_fromWarehouse", nullable = false)
    private String fromWarehouse;

    @Column(name = "delivery_destination", nullable = false)
    private String destination;

    @JsonBackReference
    @OneToMany(mappedBy = "delivery")
    private List<ProductOrder> orders;
}
