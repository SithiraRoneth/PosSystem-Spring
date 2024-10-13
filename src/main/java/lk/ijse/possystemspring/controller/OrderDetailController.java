/* Created By Sithira Roneth
 * Date :10/8/24
 * Time :12:13
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.controller;

import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dto.impl.OrderDetailsDto;
import lk.ijse.possystemspring.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderDetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    static Logger logger = LoggerFactory.getLogger(OrderDetailController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrderDetails(@RequestPart("orderId") String orderId, @RequestPart("item_code") String itemCode){
        try {
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
            orderDetailsDto.setOrderId(orderId);
            orderDetailsDto.setItemCode(itemCode);
            orderDetailService.saveOrderDetails(orderDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDto> getAllOrderDetails(){
        return orderDetailService.getAllOrderDetails();
    }
}
