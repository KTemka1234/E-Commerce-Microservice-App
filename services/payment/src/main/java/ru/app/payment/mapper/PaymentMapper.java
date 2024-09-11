package ru.app.payment.mapper;

import org.springframework.stereotype.Service;
import ru.app.payment.dto.PaymentRequest;
import ru.app.payment.entity.Payment;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }

}
