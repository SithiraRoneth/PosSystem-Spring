/* Created By Sithira Roneth
 * Date :10/13/24
 * Time :11:13
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dao.OrderDetailsDao;
import lk.ijse.possystemspring.dto.impl.OrderDetailsDto;
import lk.ijse.possystemspring.entity.impl.OrderDetailsEntity;
import lk.ijse.possystemspring.service.OrderDetailService;
import lk.ijse.possystemspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailService {
    @Autowired
    private Mapping mapping;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Override
    public void saveOrderDetails(OrderDetailsDto orderDetailsDto) {
        OrderDetailsEntity save = orderDetailsDao.save(mapping.toOrderDetailsEntity(orderDetailsDto));
        if (save == null){
            throw new DataPersistException("Order details not saved");
        }
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetailsEntity> allOrderDetails = orderDetailsDao.findAll();
        return mapping.toOrderDetailsDtoList(allOrderDetails);
    }
}
