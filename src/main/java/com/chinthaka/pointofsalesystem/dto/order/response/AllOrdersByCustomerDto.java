package com.chinthaka.pointofsalesystem.dto.order.response;


public class AllOrdersByCustomerDto {

    private Integer  customerID;
    private Integer orderID;
    private String itemName;
    private double balanceQyt;
    private double amount;

    public AllOrdersByCustomerDto() {
    }

    public AllOrdersByCustomerDto(Integer customerID, Integer orderID, String itemName, double balanceQyt, double amount) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.itemName = itemName;
        this.balanceQyt = balanceQyt;
        this.amount = amount;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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

    @Override
    public String toString() {
        return "AllOrdersByCustomerDto{" +
                "customerID=" + customerID +
                ", orderID=" + orderID +
                ", itemName='" + itemName + '\'' +
                ", balanceQyt=" + balanceQyt +
                ", amount=" + amount +
                '}';
    }
}
