package com.chinthaka.pointofsalesystem.Mapper;

import com.chinthaka.pointofsalesystem.dto.item.ItemDto;
import com.chinthaka.pointofsalesystem.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto entityToItemDto(Item item);
    Item itemDtoToEntity(ItemDto itemDto);
    List<Item> ListItemDtoToEntity(List<ItemDto> itemDtos);
    List<ItemDto> entityToListItemDto (List<Item> items);
    List<ItemDto> entityPageToListItemDto (Page<Item> items);
}
