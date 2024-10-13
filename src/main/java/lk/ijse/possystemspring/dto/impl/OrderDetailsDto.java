/* Created By Sithira Roneth
 * Date :10/13/24
 * Time :11:03
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.dto.impl;

import lk.ijse.possystemspring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto implements OrderDetailsStatus {
    private String orderId;
    private String itemCode;
}
