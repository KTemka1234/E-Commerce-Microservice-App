package ru.app.payment.dto;

import java.math.BigDecimal;
import ru.app.payment.entity.Customer;
import ru.app.payment.entity.PaymentMethod;

public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    Customer customer
) {

}
