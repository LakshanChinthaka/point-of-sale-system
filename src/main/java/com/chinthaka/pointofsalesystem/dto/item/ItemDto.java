package com.chinthaka.pointofsalesystem.dto.item;

import com.chinthaka.pointofsalesystem.enums.MeasureType;


public class ItemDto {

    private long itemId;
    private String itemName;
    private String description;
    private long itemStock;
    private MeasureType measureType;
    private long sellerPrice;
    private long sellingPrice;
    private boolean activeStatus;

    public ItemDto() {
    }

    public ItemDto(long itemId, String itemName, String description, long itemStock, MeasureType measureType, long sellerPrice, long sellingPrice, boolean activeStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.itemStock = itemStock;
        this.measureType = measureType;
        this.sellerPrice = sellerPrice;
        this.sellingPrice = sellingPrice;
        this.activeStatus = activeStatus;
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

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", itemStock=" + itemStock +
                ", measureType=" + measureType +
                ", sellerPrice=" + sellerPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeStatus=" + activeStatus +
                '}';
    }
}


