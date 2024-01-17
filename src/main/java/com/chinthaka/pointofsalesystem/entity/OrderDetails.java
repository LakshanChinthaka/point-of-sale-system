package com.chinthaka.pointofsalesystem.entity;


import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_details_id")
    private Integer orderDetailsID;

    @Column(name = "item_name",nullable = false,length = 50)
    private String itemName;

    @Column(name = "qyt",nullable = false)
    private double balanceQyt;

    @Column(name = "amount",nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderDetailsID, String itemName, double balanceQyt, double amount, Order order, Item item) {
        this.orderDetailsID = orderDetailsID;
        this.itemName = itemName;
        this.balanceQyt = balanceQyt;
        this.amount = amount;
        this.order = order;
        this.item = item;
    }

    public OrderDetails(String itemName, double balanceQyt, double amount, Order order, Item item) {
        this.itemName = itemName;
        this.balanceQyt = balanceQyt;
        this.amount = amount;
        this.order = order;
        this.item = item;
    }

    public Integer getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(Integer orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getBalanceQyt() {
        return balanceQyt;
    }

    public void setBalanceQyt(double balanceQyt) {
        this.balanceQyt = balanceQyt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem(Item byId) {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsID=" + orderDetailsID +
                ", itemName='" + itemName + '\'' +
                ", balanceQyt=" + balanceQyt +
                ", amount=" + amount +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}
