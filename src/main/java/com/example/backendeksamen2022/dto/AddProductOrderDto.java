package com.example.backendeksamen2022.dto;

public class AddProductOrderDto {

    private Long productId;
    private Long deliveryId;

    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

}
