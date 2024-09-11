package ru.app.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
