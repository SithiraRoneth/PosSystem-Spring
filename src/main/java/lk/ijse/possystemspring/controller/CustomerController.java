/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:28
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.controller;

import lk.ijse.possystemspring.Exception.CustomerNotFoundException;
import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dto.impl.CustomerDto;
import lk.ijse.possystemspring.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDto customerDto) {
        try {
            customerService.saveCustomer(customerDto);
            logger.info("Customer saved successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{cus_id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("cus_id") String cus_id, @RequestBody CustomerDto UpdatedcustomerDto) {
        try {
            customerService.updateCustomer(cus_id, UpdatedcustomerDto);
            logger.info("Customer updated successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{cus_id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("cus_id") String cus_id) {
        try {
            customerService.deleteCustomer(cus_id);
            logger.info("Customer deleted successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
