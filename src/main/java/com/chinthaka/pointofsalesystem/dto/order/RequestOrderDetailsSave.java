package com.chinthaka.pointofsalesystem.dto.order;

public class RequestOrderDetailsSave {
    private String itemName;
    private double balanceQyt;
    private double amount;
    private Integer order;
    private long item;

    public RequestOrderDetailsSave() {
    }

    public RequestOrderDetailsSave(String itemName, double balanceQyt, double amount, Integer order, Integer item) {
        this.itemName = itemName;
        this.balanceQyt = balanceQyt;
        this.amount = amount;
        this.order = order;
        this.item = item;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public long getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "RequestOrderDetailsSaveDto{" +
                "itemName='" + itemName + '\'' +
                ", balanceQyt=" + balanceQyt +
                ", amount=" + amount +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}
