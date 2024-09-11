package ru.app.order.mapper;

import org.springframework.stereotype.Service;
import ru.app.order.dto.OrderLineRequest;
import ru.app.order.dto.OrderLineResponse;
import ru.app.order.entity.Order;
import ru.app.order.entity.OrderLine;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
