package ru.app.product.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
    @NotNull(message = "Product id is required")
    Integer productId,

    @NotNull(message = "Quantity should be positive")
    double quantity
) {

}
