package com.chinthaka.pointofsalesystem.service.impl;


import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.entity.Customer;
import com.chinthaka.pointofsalesystem.entity.Order;
import com.chinthaka.pointofsalesystem.entity.OrderDetails;
import com.chinthaka.pointofsalesystem.exception.NotFoundException;
import com.chinthaka.pointofsalesystem.exception.ValidationException;
import com.chinthaka.pointofsalesystem.exception.handleException;
import com.chinthaka.pointofsalesystem.repo.CustomerRepo;
import com.chinthaka.pointofsalesystem.repo.ItemRepo;
import com.chinthaka.pointofsalesystem.repo.OrderDetailsRepo;
import com.chinthaka.pointofsalesystem.repo.OrderRepo;
import com.chinthaka.pointofsalesystem.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;
    private final OrderRepo orderRepo;
    private final OrderDetailsRepo orderDetailsRepo;

    public OrderServiceImpl(ItemRepo itemRepo, CustomerRepo customerRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo) {
        this.itemRepo = itemRepo;
        this.customerRepo = customerRepo;

        this.orderRepo = orderRepo;
        this.orderDetailsRepo = orderDetailsRepo;
    }

    @Override
    @Transactional
    public String placeOrder(RequestOrderSaveDto requestOrderSaveDto) {
        // get customer by customer id
        Customer customer = customerRepo.findById(requestOrderSaveDto.getCustomers())
                .orElse(null);
        // check customer is null
        if (Objects.isNull(customer)) {
            throw new NotFoundException("Customer Not Found");
        }
        if (!customer.isActiveStatus()) {
            throw new ValidationException("Customer is inactive");
        }
        // assign order details(order data, total amount,customer) from requestOrderSaveDto
        try {
            final Order order = new Order(
                    requestOrderSaveDto.getOrderData(),
                    requestOrderSaveDto.getTotal(),
                    customer
            );
            // save order details and get it order ID
            int orderId = orderRepo.save(order).getOrderID();
            //check order details is saved
            if (orderRepo.existsById(order.getOrderID())) {
                List<OrderDetails> orderDetailsList = requestOrderSaveDto.getOrderDetailsList()
                        .stream()
                        .map(orderDetailsDto -> new OrderDetails( // OrderDetails means OrderDetails Entity
                                orderDetailsDto.getItemName(),
                                orderDetailsDto.getBalanceQyt(),
                                orderDetailsDto.getAmount(),
                                order,
                                itemRepo.getById(orderDetailsDto.getItem())
                        ))
                        .collect(Collectors.toList());
                orderDetailsRepo.saveAll(orderDetailsList);
            }
            return "Order id- " + orderId + " Successfully";
        } catch (Exception e){
            throw new handleException("Something went wrong");
        }
    }
}
