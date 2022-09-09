package com.sahal.itemsservice.controller;

import com.sahal.itemsservice.dto.ItemDto;
import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.model.ShoppingCart;
import com.sahal.itemsservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(
            @RequestBody ItemDto itemDto) throws Exception {
        ItemDto createdItem = itemService.createItem(itemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdItem);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ItemDto> updateItem(
            @PathVariable long id,
            @RequestBody ItemDto itemDto) throws Exception {
        ItemDto updatedItem = itemService.updateItem(id, itemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedItem);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ItemDto>> getAllItems() throws Exception {
        List<ItemDto> itemList = itemService.getAllItems();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(itemList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemDto> getItemById(
            @PathVariable long id) throws Exception {
        ItemDto itemDto = itemService.getItemById(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(itemDto);
    }
}
