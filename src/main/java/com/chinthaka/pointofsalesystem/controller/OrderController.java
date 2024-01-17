package com.chinthaka.pointofsalesystem.controller;

import com.chinthaka.pointofsalesystem.dto.order.RequestOrderDetailsSave;
import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.service.OrderService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/place-order")
    public ResponseEntity<StandardResponse> placeOrder(
            @RequestBody RequestOrderSaveDto requestOrderSaveDto){
        String data = orderService.placeOrder(requestOrderSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data), HttpStatus.CREATED
        );
    }
}
