package lk.ijse.possystemspring.dao;

import lk.ijse.possystemspring.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,String> {
}
