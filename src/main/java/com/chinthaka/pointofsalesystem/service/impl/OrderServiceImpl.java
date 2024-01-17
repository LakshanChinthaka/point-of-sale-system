package com.chinthaka.pointofsalesystem.service.impl;


import com.chinthaka.pointofsalesystem.Mapper.OrderMapper;
import com.chinthaka.pointofsalesystem.dto.order.RequestOrderSaveDto;
import com.chinthaka.pointofsalesystem.dto.order.response.AllOrdersByCustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedResponse;
import com.chinthaka.pointofsalesystem.dto.query.GetOrderDetailsByCustomer;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    private final OrderMapper orderMapper;

    public OrderServiceImpl(ItemRepo itemRepo, CustomerRepo customerRepo, OrderRepo orderRepo, OrderDetailsRepo orderDetailsRepo, OrderMapper orderMapper) {
        this.itemRepo = itemRepo;
        this.customerRepo = customerRepo;

        this.orderRepo = orderRepo;
        this.orderDetailsRepo = orderDetailsRepo;
        this.orderMapper = orderMapper;
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

    @Override
    public PaginatedResponse placeOrder(Integer customerId, int page, int size) {
        if (null == customerId){
            throw new NotFoundException("Customer Id not provide");
        }
        boolean customer = customerRepo.findById(customerId).isPresent();
        if (!customer){
            throw new NotFoundException("Customer Not found");
        }
        List<GetOrderDetailsByCustomer> getOrderDetailsByCustomers = orderRepo
                .getOrderDetailsByCustomers(customerId,PageRequest.of(page,size));

        List<AllOrdersByCustomerDto> allOrdersByCustomerDtos = orderMapper.list(getOrderDetailsByCustomers);
        return new PaginatedResponse(
                allOrdersByCustomerDtos,
                allOrdersByCustomerDtos.size(),
                0
        );
    }
}
