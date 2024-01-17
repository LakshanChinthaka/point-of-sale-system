package com.chinthaka.pointofsalesystem.service;

import com.chinthaka.pointofsalesystem.dto.item.ItemDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllItem;

public interface ItemService {

    String saveItem(ItemDto itemDto);

    PaginatedGetAllItem getAllItems(int page, int size);

    ItemDto getItemsById(long itemId);

    String updateItem(ItemDto itemDto);
}
