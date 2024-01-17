package com.chinthaka.pointofsalesystem.dto.query;


public interface GetOrderDetailsByCustomer {

    Integer  getCustomerID();
    Integer getOrderID();
    String getItemName();
    double getBalanceQyt();
    double getAmount();
}
