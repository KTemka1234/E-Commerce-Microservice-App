package ru.app.order.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.order.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    List<OrderLine> findAllByOrderId(Integer orderId);
}
