package lk.ijse.possystemspring.service;

import lk.ijse.possystemspring.dto.impl.OrderDto;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
}
