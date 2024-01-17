package com.chinthaka.pointofsalesystem.entity;

import com.chinthaka.pointofsalesystem.enums.MeasureType;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_name",nullable = false,length = 50)
    private String itemName;

    @Column(name = "item_description",length = 200)
    private String description;

    @Column(name = "item_stock",nullable = false)
    private long itemStock;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",nullable = false)
    private MeasureType measureType;

    @Column(name = "seller_price",nullable = false)
    private long sellerPrice;

    @Column(name = "selling_price")
    private long sellingPrice;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    @OneToMany(mappedBy="item")
    private Set<OrderDetails> orderDetails;

    public Item() {
    }

    public Item(long itemId, String itemName, String description, long itemStock, MeasureType measureType, long sellerPrice, long sellingPrice, boolean activeStatus, Set<OrderDetails> orderDetails) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.itemStock = itemStock;
        this.measureType = measureType;
        this.sellerPrice = sellerPrice;
        this.sellingPrice = sellingPrice;
        this.activeStatus = activeStatus;
        this.orderDetails = orderDetails;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getItemStock() {
        return itemStock;
    }

    public void setItemStock(long itemStock) {
        this.itemStock = itemStock;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public long getSellerPrice() {
        return sellerPrice;
    }

    public void setSellerPrice(long sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    public long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", itemStock=" + itemStock +
                ", measureType=" + measureType +
                ", sellerPrice=" + sellerPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeStatus=" + activeStatus +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
