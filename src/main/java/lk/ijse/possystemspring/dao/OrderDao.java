package lk.ijse.possystemspring.dao;

import lk.ijse.possystemspring.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,String> {
}
