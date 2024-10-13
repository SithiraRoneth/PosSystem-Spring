/* Created By Sithira Roneth
 * Date :10/13/24
 * Time :11:04
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.ijse.possystemspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsEntity implements SuperEntity {
    @Id
    private String od_id;
    private String orderQty;

    @ManyToOne
    @JoinColumn(name = "code",nullable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderEntity order;
}
