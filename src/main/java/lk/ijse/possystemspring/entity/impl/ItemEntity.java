/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:35
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.possystemspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String code;
    private String itemName;
    private int unitPrice;
    private int qtyOnHand;
}
