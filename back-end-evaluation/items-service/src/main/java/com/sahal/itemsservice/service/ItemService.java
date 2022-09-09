package com.sahal.itemsservice.service;

import com.sahal.itemsservice.dto.ItemDto;
import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.exception.GlobalException;
import com.sahal.itemsservice.exception.ResourceNotFoundException;
import com.sahal.itemsservice.mapper.CartMapper;
import com.sahal.itemsservice.mapper.ItemMapper;
import com.sahal.itemsservice.model.Item;
import com.sahal.itemsservice.model.ShoppingCart;
import com.sahal.itemsservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CartMapper cartMapper;

    public ItemDto createItem(ItemDto itemDto) throws GlobalException {
        try {
            Item item = itemMapper.dtoToEntity(itemDto);
            Item createdItem = itemRepository.save(item);
            ItemDto createdItemDto = itemMapper.entityToDto(createdItem);
            return createdItemDto;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Item not created due to some internal error!");
        }
    }

    public List<ItemDto> getAllItems() throws GlobalException {
        try {
            List<Item> itemList = itemRepository.findAll();
            List<ItemDto> itemDtoList = itemMapper.entityToDto(itemList);
            return itemDtoList;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Item list not found due to some internal error!");
        }
    }

    public ItemDto getItemById(long id) throws GlobalException {
        try {
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Item with id "+id+" not found"));
            ItemDto itemDto = itemMapper.entityToDto(item);
            return itemDto;
        } catch (Exception ex) {
            log.error("Exception caught "+ex.getMessage());
            ResourceNotFoundException resourceNotFoundException
                    = ex instanceof ResourceNotFoundException ? ((ResourceNotFoundException) ex) : null;
            if(resourceNotFoundException != null)
                throw new ResourceNotFoundException(ex.getLocalizedMessage());
            else
                throw new GlobalException("Employee with id "+id+" not found due to some internal error!");
        }
    }

    public ItemDto updateItem(long id, ItemDto itemDto) throws GlobalException {
        try {
            boolean isItemAlreadyPresent = itemRepository.findById(id).isPresent();
            Item item = itemMapper.dtoToEntity(itemDto);
            item.setItemId(id);
            if (isItemAlreadyPresent) {
                Item updatedItem = itemRepository.save(item);
                ItemDto updatedItemDto = itemMapper.entityToDto(updatedItem);
                return updatedItemDto;
            } else {
                throw new ResourceNotFoundException("Item with id "+id+" not found");
            }
        } catch (Exception ex) {
            log.error("Exception caught "+ex.getMessage());
            ResourceNotFoundException resourceNotFoundException
                    = ex instanceof ResourceNotFoundException ? ((ResourceNotFoundException) ex) : null;
            if(resourceNotFoundException != null)
                throw new ResourceNotFoundException(ex.getLocalizedMessage());
            else
                throw new GlobalException("Item not updated due to some internal error!");
        }
    }
}
