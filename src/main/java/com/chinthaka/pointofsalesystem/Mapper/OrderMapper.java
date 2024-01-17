package com.chinthaka.pointofsalesystem.Mapper;

import com.chinthaka.pointofsalesystem.dto.order.OrderSaveDto;
import com.chinthaka.pointofsalesystem.dto.order.RequestOrderDetailsSave;
import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.dto.order.response.AllOrdersByCustomerDto;
import com.chinthaka.pointofsalesystem.dto.query.GetOrderDetailsByCustomer;
import com.chinthaka.pointofsalesystem.entity.Item;
import com.chinthaka.pointofsalesystem.entity.Order;
import com.chinthaka.pointofsalesystem.entity.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    List<AllOrdersByCustomerDto> list(List<GetOrderDetailsByCustomer> getOrderDetailsByCustomers);

//    OrderSaveDto requestOrderSaveDtoToEntity(RequestOrderSaveDto requestOrderSaveDto);

//    @Mapping(target = "orderDetailsList", source = "orderDetailsList")
//    List<OrderDetails> requestOrderSaveDtoToOrderDetails(List<RequestOrderDetailsSave> requestOrderDetailsSaveList);

//    default Order map(Integer orderId) {
//        return (orderId != null) ? orderRepository.findById(orderId).orElse(null) : null;
//    }
//
//    default Item map(long itemId) {
//        return (itemId > 0) ? itemRepository.findById(itemId).orElse(null) : null;
//    }
//
//    default List<OrderDetails> requestOrderSaveDtoToOrderDetails(RequestOrderSaveDto requestOrderSaveDto) {
//        List<OrderDetails> orderDetails = new ArrayList<>();
//
//
//        return orderDetails;
//    }

//    default List<OrderDetails> mapOrderDetailsList(List<RequestOrderSaveDto> requestOrderSaveDtos) {
//        return requestOrderSaveDtos.stream()
//                .map(this::mapRequestOrderDetailsSaveToOrderDetails)
//                .collect(Collectors.toList());
//    }
}
