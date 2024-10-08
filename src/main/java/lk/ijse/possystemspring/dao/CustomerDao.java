package lk.ijse.possystemspring.dao;

import lk.ijse.possystemspring.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
