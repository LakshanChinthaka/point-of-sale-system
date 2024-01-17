package com.chinthaka.pointofsalesystem.service;

import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;

public interface OrderService {
    String placeOrder(RequestOrderSaveDto requestOrderSaveDto);
}
