/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:32
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.controller;

import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dto.impl.OrderDto;
import lk.ijse.possystemspring.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.saveOrder(orderDto);
            logger.info("Order saved successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
