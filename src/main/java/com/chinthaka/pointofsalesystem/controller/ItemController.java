package com.chinthaka.pointofsalesystem.controller;

import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;
import com.chinthaka.pointofsalesystem.dto.item.ItemDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllItem;
import com.chinthaka.pointofsalesystem.service.ItemService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDto itemDto){
        String data = itemService.saveItem(itemDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-item", params = {"page","size"})
    public ResponseEntity<StandardResponse> getAllItems(
            @RequestParam(name = "page") int page, @RequestParam(name = "size") @Max(50) int size){

        PaginatedGetAllItem paginatedGetAllItem = itemService.getAllItems(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully", paginatedGetAllItem), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-item-by-id", params = {"id"})
    public ResponseEntity<StandardResponse> getItemsById(
            @RequestParam(name = "id") long itemId ){

        ItemDto items = itemService.getItemsById(itemId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully", items), HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDto itemDto){
        String data = itemService.updateItem(itemDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data), HttpStatus.OK
        );
    }


}
