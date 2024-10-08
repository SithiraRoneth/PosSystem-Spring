package lk.ijse.possystemspring.service;

import lk.ijse.possystemspring.dto.impl.ItemDto;

public interface ItemService {
    void saveItem(ItemDto itemDto);
    void updateItem(String itemId,ItemDto itemDto);
    void deleteItem(String itemId);
}
