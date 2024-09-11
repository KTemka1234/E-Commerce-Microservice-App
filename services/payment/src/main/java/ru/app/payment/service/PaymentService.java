package ru.app.payment.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.app.payment.dto.PaymentRequest;
import ru.app.payment.entity.Payment;
import ru.app.payment.kafka.NotificationProducer;
import ru.app.payment.kafka.PaymentNotificationRequest;
import ru.app.payment.mapper.PaymentMapper;
import ru.app.payment.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        Payment payment = repository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
            new PaymentNotificationRequest(
                request.orderReference(),
                request.amount(),
                request.paymentMethod(),
                request.customer().firstName(),
                request.customer().lastName(),
                request.customer().email())
        );
		return payment.getId();
	}
}
