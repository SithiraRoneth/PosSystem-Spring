/* Created By Sithira Roneth
 * Date :10/8/24
 * Time :12:13
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.controller;

import lk.ijse.possystemspring.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orderDetails")
public class OrderDetailController {
    @Autowired
    private OrderService orderService;
    static Logger logger = LoggerFactory.getLogger(OrderDetailController.class);
}
