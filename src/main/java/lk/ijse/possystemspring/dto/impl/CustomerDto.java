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
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private int salary;
}
