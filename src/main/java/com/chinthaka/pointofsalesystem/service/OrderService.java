package com.chinthaka.pointofsalesystem.service;

import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.dto.order.response.AllOrdersByCustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedResponse;

public interface OrderService {
    String placeOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponse placeOrder(Integer customerId, int page, int size);
}
