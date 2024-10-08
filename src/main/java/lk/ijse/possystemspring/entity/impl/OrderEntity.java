/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:35
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class OrderEntity {
    @Id
    private String orderId;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "cus_Id",nullable = false)
    private CustomerEntity cusId;
}
