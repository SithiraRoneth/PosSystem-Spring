/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:34
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String code;
    private String itemName;
    private int unitPrice;
    private int qtyOnHand;
}
