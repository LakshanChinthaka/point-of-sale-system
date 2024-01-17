package com.chinthaka.pointofsalesystem.entity;



import com.chinthaka.pointofsalesystem.dto.order.RequestOrderDetailsSave;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "purchase_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderID;

    @Column(name = "order_data",columnDefinition = "DATETIME")
    private Date orderData;

    @Column(name = "total",nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @OneToMany(mappedBy="order")
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(Integer orderID, Date orderData, double total, Customer customers, List<OrderDetails> orderDetails) {
        this.orderID = orderID;
        this.orderData = orderData;
        this.total = total;
        this.customers = customers;
        this.orderDetails = orderDetails;
    }

    public Order(Date orderData, double total, Customer customers) {
        this.orderData = orderData;
        this.total = total;
        this.customers = customers;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderData=" + orderData +
                ", total=" + total +
                ", customers=" + customers +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
