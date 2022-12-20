package com.example.backendeksamen2022.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddProductOrderDto {

    private Long productId;
    private Long deliveryId;
    private int quantity;




}
