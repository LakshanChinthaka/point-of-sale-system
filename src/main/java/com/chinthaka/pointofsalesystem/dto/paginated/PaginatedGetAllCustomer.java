package com.chinthaka.pointofsalesystem.dto.paginated;

import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;


import java.util.List;


public class PaginatedGetAllCustomer {
    List<CustomerDto> list;
    private long dataCount;
    private long totalDataCount;

    public PaginatedGetAllCustomer() {
    }

    public PaginatedGetAllCustomer(List<CustomerDto> list, long dataCount, long totalDataCount) {
        this.list = list;
        this.dataCount = dataCount;
        this.totalDataCount = totalDataCount;
    }

    public List<CustomerDto> getList() {
        return list;
    }

    public void setList(List<CustomerDto> list) {
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
        return "PaginatedGetAllCustomer{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                ", totalDataCount=" + totalDataCount +
                '}';
    }
}
