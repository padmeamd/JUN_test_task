package com.shoppinglist.shopping.list.app.controller;


import com.shoppinglist.shopping.list.app.entity.ShoppingItem;
import com.shoppinglist.shopping.list.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ShoppingItem>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingItem> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PostMapping
    public ResponseEntity<ShoppingItem> addItem(@RequestBody ShoppingItem item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingItem> updateItem(@PathVariable Long id, @RequestBody ShoppingItem newItem) {
        return ResponseEntity.ok(itemService.updateItem(id, newItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingItem> deleteItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }
}
