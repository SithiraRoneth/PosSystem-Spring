/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:35
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String orderId;
    private String cusId;
    private LocalDate date;
}
