/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:38
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.util;

import lk.ijse.possystemspring.dto.impl.CustomerDto;
import lk.ijse.possystemspring.dto.impl.ItemDto;
import lk.ijse.possystemspring.dto.impl.OrderDto;
import lk.ijse.possystemspring.entity.impl.CustomerEntity;
import lk.ijse.possystemspring.entity.impl.ItemEntity;
import lk.ijse.possystemspring.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity toCustomerEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto toCustomerDto(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>() {}.getType());
    }

    public ItemEntity toItemEntity(ItemDto itemDto) {
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto toItemDto(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDto.class);
    }
    public List<ItemDto> toItemDtoList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDto>>() {}.getType());
    }

    public OrderEntity toOrderEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }
    public OrderDto toOrderDto(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDto.class);
    }
    public List<OrderDto> toOrderDtoList(List<OrderEntity> orderEntityList) {
        return modelMapper.map(orderEntityList, new TypeToken<List<OrderDto>>() {}.getType());
    }

}
