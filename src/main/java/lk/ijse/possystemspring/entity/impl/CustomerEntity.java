/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:35
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.possystemspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private int salary;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orderId;
}
