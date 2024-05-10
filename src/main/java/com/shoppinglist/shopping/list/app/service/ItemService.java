package com.shoppinglist.shopping.list.app.service;


import com.shoppinglist.shopping.list.app.entity.ShoppingItem;
import com.shoppinglist.shopping.list.app.exceptions.EntityNotFoundException;
import com.shoppinglist.shopping.list.app.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ShoppingItem> getAllItems() {
        log.info("Retrieving all items");
        return itemRepository.findAll();
    }

    public ShoppingItem getItemById(Long id) {
        log.info("Getting item by id: {}", id);
        var result =  itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        log.info("Item by id: {} found", id);
        return result;
    }

    public ShoppingItem addItem(ShoppingItem item) {
        log.info("Saving new item with name: {}", item.getName());
        var result = itemRepository.save(item);
        log.info("New item with name {} saved", item.getName());
        return result;
    }

    public ShoppingItem updateItem(Long id, ShoppingItem newItem) {
        log.info("Trying to update item with id: {}", id);
        var previousItem = getItemById(id);
        itemRepository.update(newItem.getName(), newItem.getQuantity(), newItem.getPrice(), id);
        log.info("Item with id: {} successfully updated", id);
        return previousItem;
    }

    public ShoppingItem deleteItem(Long id) {
        log.info("Trying to delete item with id: {}", id);
        var result = itemRepository.findById(id);
        var item = result.orElseThrow(EntityNotFoundException::new);
        itemRepository.deleteById(id);
        log.info("Item with id: {} successfully deleted", id);
        return item;
    }
}