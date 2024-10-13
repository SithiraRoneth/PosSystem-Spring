package lk.ijse.possystemspring.service;

import lk.ijse.possystemspring.dto.impl.OrderDetailsDto;

import java.util.List;

public interface OrderDetailService {
    void saveOrderDetails(OrderDetailsDto orderDetailsDto);
    List<OrderDetailsDto> getAllOrderDetails();
}
