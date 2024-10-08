/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:38
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.dao.ItemDao;
import lk.ijse.possystemspring.dto.impl.ItemDto;
import lk.ijse.possystemspring.entity.impl.ItemEntity;
import lk.ijse.possystemspring.service.ItemService;
import lk.ijse.possystemspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        ItemEntity savedItem = itemMapping.toItemEntity(itemDto);
        if (savedItem == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public void updateItem(String itemId, ItemDto itemDto) {
        Optional<ItemEntity> findItemId = itemDao.findById(itemId);
        if (!findItemId.isPresent()) {
            throw new DataPersistException("Item not found");
        } else {
            findItemId.get().setItemName(itemDto.getItemName());
            findItemId.get().setUnitPrice(itemDto.getUnitPrice());
            findItemId.get().setQtyOnHand(itemDto.getQtyOnHand());

            ItemEntity itemEntity = itemMapping.toItemEntity(itemDto);
            itemDao.save(itemEntity);
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> findItemId = itemDao.findById(itemId);
        if (!findItemId.isPresent()) {
            throw new DataPersistException("Item not found");
        } else {
            itemDao.deleteById(itemId);
        }
    }
}
