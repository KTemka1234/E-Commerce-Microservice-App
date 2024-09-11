package ru.app.order.kafka;

import java.math.BigDecimal;
import java.util.List;
import ru.app.order.entity.PaymentMethod;
import ru.app.order.feignclient.customer.CustomerResponse;
import ru.app.order.feignclient.product.PurchaseResponse;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
        
}
