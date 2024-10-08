/* Created By Sithira Roneth
 * Date :10/6/24
 * Time :09:28
 * Project Name :PosSystem-Spring
 * */
package lk.ijse.possystemspring.controller;

import lk.ijse.possystemspring.Exception.DataPersistException;
import lk.ijse.possystemspring.Exception.ItemNotFoundException;
import lk.ijse.possystemspring.dto.impl.ItemDto;
import lk.ijse.possystemspring.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDto itemDto) {
        try {
            itemService.saveItem(itemDto);
            logger.info("Item saved successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{item_code}")
    public ResponseEntity<Void> updateItem(@PathVariable("item_code") String item_code, @RequestBody ItemDto itemDto) {
        try {
            itemService.updateItem(item_code, itemDto);
            logger.info("Item updated successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{item_code}")
    public ResponseEntity<Void> deleteItem(@PathVariable("item_code") String item_code) {
        try {
            itemService.deleteItem(item_code);
            logger.info("Item deleted successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
