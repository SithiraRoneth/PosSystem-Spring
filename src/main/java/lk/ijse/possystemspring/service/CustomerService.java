package lk.ijse.possystemspring.service;

import lk.ijse.possystemspring.dto.impl.CustomerDto;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);
    void updateCustomer(String cus_id,CustomerDto customerDto);
    void deleteCustomer(String cus_id);
}
