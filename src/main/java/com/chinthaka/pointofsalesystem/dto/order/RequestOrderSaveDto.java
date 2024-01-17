package com.chinthaka.pointofsalesystem.dto.order;

import java.util.Date;
import java.util.List;


public class RequestOrderSaveDto {
    private Date orderData;
    private double total;
    private Integer customers;
    private List<RequestOrderDetailsSave> orderDetailsList;

    public RequestOrderSaveDto() {
    }

    public RequestOrderSaveDto(Date orderData, double total, Integer customers, List<RequestOrderDetailsSave> orderDetailsList) {

        this.orderData = orderData;
        this.total = total;
        this.customers = customers;
        this.orderDetailsList = orderDetailsList;
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

    public Integer getCustomers() {
        return customers;
    }

    public void setCustomers(Integer customers) {
        this.customers = customers;
    }

    public List<RequestOrderDetailsSave> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<RequestOrderDetailsSave> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "RequestOrderSaveDto{" +
                "orderData=" + orderData +
                ", total=" + total +
                ", customers=" + customers +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}
