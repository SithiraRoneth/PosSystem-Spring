/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:38
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dao.CustomerDao;
import lk.ijse.possystemspring.dto.impl.CustomerDto;
import lk.ijse.possystemspring.entity.impl.CustomerEntity;
import lk.ijse.possystemspring.service.CustomerService;
import lk.ijse.possystemspring.util.AppUtil;
import lk.ijse.possystemspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerDto.setId(AppUtil.generateCustomerId());
        CustomerEntity savedCustomer = customerMapping.toCustomerEntity(customerDto);
        if (savedCustomer == null) {
            throw new DataPersistException("Customer Not Saved");
        }
    }

    @Override
    public void updateCustomer(String cus_id, CustomerDto customerDto) {
        Optional<CustomerEntity> findCustomerId = customerDao.findById(cus_id);
        if (!findCustomerId.isPresent()) {
            throw new DataPersistException("Customer Not Found");
        } else {
            findCustomerId.get().setName(customerDto.getName());
            findCustomerId.get().setAddress(customerDto.getAddress());
            findCustomerId.get().setSalary(customerDto.getSalary());

            CustomerEntity updatedCustomer = customerMapping.toCustomerEntity(customerDto);
            customerDao.save(updatedCustomer);
        }
    }

    @Override
    public void deleteCustomer(String cus_id) {
        Optional<CustomerEntity> findDeletedId = customerDao.findById(cus_id);
        if (!findDeletedId.isPresent()) {
            throw new DataPersistException("Customer Not Found");
        } else {
            customerDao.deleteById(cus_id);
        }
    }
}
