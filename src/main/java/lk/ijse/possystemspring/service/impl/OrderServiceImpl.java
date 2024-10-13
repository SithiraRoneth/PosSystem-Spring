/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:38
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dao.OrderDao;
import lk.ijse.possystemspring.dto.impl.OrderDto;
import lk.ijse.possystemspring.entity.impl.OrderEntity;
import lk.ijse.possystemspring.service.OrderService;
import lk.ijse.possystemspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping orderMapping;

    @Override
    public void saveOrder(OrderDto orderDto) {
        OrderEntity savedOrder = orderMapping.toOrderEntity(orderDto);
        if (savedOrder == null) {
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> allOrders = orderDao.findAll();
        return orderMapping.toOrderDtoList(allOrders);
    }
}
