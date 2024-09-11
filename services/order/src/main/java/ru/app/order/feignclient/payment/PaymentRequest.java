package ru.app.order.feignclient.payment;

import java.math.BigDecimal;
import ru.app.order.entity.PaymentMethod;
import ru.app.order.feignclient.customer.CustomerResponse;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
    
}
