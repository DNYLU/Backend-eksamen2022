package com.example.backendeksamen2022.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddDeliveryDto {
    private LocalDate date;
    private String fromWarehouse;
    private String destination;
}
