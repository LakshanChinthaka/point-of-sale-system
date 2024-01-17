package com.chinthaka.pointofsalesystem.service.impl;

import com.chinthaka.pointofsalesystem.Mapper.ItemMapper;
import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;
import com.chinthaka.pointofsalesystem.dto.item.ItemDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllItem;
import com.chinthaka.pointofsalesystem.entity.Item;
import com.chinthaka.pointofsalesystem.exception.NotFoundException;
import com.chinthaka.pointofsalesystem.exception.ResourceAlreadyExistException;
import com.chinthaka.pointofsalesystem.repo.ItemRepo;
import com.chinthaka.pointofsalesystem.service.ItemService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepo itemRepo, ItemMapper itemMapper) {
        this.itemRepo = itemRepo;
        this.itemMapper = itemMapper;
    }

    @Override
    public String saveItem(ItemDto itemDto) {
        if (!itemRepo.existsById(itemDto.getItemId())) {
            final Item item = itemMapper.itemDtoToEntity(itemDto);
            itemRepo.save(item);
            return "Item Successfully Saved";
        } else {
            throw new ResourceAlreadyExistException("Item id - " + itemDto.getItemId() + " Already Exist");
        }
    }

    @Override
    public PaginatedGetAllItem getAllItems(int page, int size) {
        final Page<Item> items = itemRepo.findAll(PageRequest.of(page, size));
        if (!items.isEmpty()) {
            return new PaginatedGetAllItem(
                    itemMapper.entityPageToListItemDto(items),
                    items.getNumberOfElements(),
                    items.getTotalElements()
            );
        } else {
            throw new NotFoundException("Items not found");
        }
    }

    @Override
    public ItemDto getItemsById(long itemId) {
        if (itemRepo.existsById(itemId)) {
           final Item item = itemRepo.findById(itemId).get();
           return itemMapper.entityToItemDto(item);
        } else {
            throw new NotFoundException("Item id - " + itemId + " Not found");
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) {
        if (itemRepo.existsById(itemDto.getItemId())){
            Item item = itemRepo.findById(itemDto.getItemId()).get();
            item = itemMapper.itemDtoToEntity(itemDto);
            itemRepo.save(item);
            return "Update Successfully";
        }else {
            throw new NotFoundException("Item id-"+itemDto.getItemId()+" Not found");
        }
    }


}
