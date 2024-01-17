package com.chinthaka.pointofsalesystem.controller;

import com.chinthaka.pointofsalesystem.dto.order.RequestOrderDetailsSave;
import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.dto.order.response.AllOrdersByCustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedResponse;
import com.chinthaka.pointofsalesystem.service.OrderService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import jakarta.validation.constraints.Max;
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

    @GetMapping(path = "/all-order-by-customer-id", params = {"id","page","size"})
    public ResponseEntity<StandardResponse> AllOrderByCustomerID(
            @RequestParam(name = "id") Integer customerId,
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") @Max(20) int size
    ){
        PaginatedResponse data = orderService.placeOrder(customerId,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data), HttpStatus.OK
        );
    }
}
