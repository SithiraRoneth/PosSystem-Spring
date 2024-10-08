package lk.ijse.possystemspring.dao;

import lk.ijse.possystemspring.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
