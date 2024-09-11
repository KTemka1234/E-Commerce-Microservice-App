package ru.app.payment.kafka;

import java.math.BigDecimal;
import ru.app.payment.entity.PaymentMethod;

public record PaymentNotificationRequest(
    String orderReference,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFirstName,
    String customerLastName,
    String customerEmail
) {

}
