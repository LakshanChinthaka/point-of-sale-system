package com.chinthaka.pointofsalesystem.dto.paginated;

import com.chinthaka.pointofsalesystem.dto.item.ItemDto;


import java.util.List;

public class PaginatedGetAllItem {

    List<ItemDto> list;
    private long dataCount;
    private long totalDataCount;

    public PaginatedGetAllItem() {
    }

    public PaginatedGetAllItem(List<ItemDto> list, long dataCount, long totalDataCount) {
        this.list = list;
        this.dataCount = dataCount;
        this.totalDataCount = totalDataCount;
    }

    public List<ItemDto> getList() {
        return list;
    }

    public void setList(List<ItemDto> list) {
        this.list = list;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public long getTotalDataCount() {
        return totalDataCount;
    }

    public void setTotalDataCount(long totalDataCount) {
        this.totalDataCount = totalDataCount;
    }

    @Override
    public String toString() {
        return "PaginatedGetAllItem{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                ", totalDataCount=" + totalDataCount +
                '}';
    }
}
