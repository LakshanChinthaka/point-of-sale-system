package com.chinthaka.pointofsalesystem.dto.order;

import com.chinthaka.pointofsalesystem.entity.Customer;

import java.util.Date;

public class OrderSaveDto {

    private Date orderData;
    private double total;
    private Customer customers;

    public OrderSaveDto() {
    }

    public OrderSaveDto(Date orderData, double total, Customer customers) {
        this.orderData = orderData;
        this.total = total;
        this.customers = customers;
    }

    public Date getOrderData() {
        return orderData;
    }

    public void setOrderData(Date orderData) {
        this.orderData = orderData;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "OrderSaveDto{" +
                "orderData=" + orderData +
                ", total=" + total +
                ", customers=" + customers +
                '}';
    }
}
