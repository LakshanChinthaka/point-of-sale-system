package com.chinthaka.pointofsalesystem.dto.paginated;

import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;
import com.chinthaka.pointofsalesystem.dto.order.response.AllOrdersByCustomerDto;

import java.util.List;

public class PaginatedResponse {

    List<AllOrdersByCustomerDto> list;
    private long dataCount;
    private long totalDataCount;

    public PaginatedResponse() {
    }

    public PaginatedResponse(List<AllOrdersByCustomerDto> list, long dataCount, long totalDataCount) {
        this.list = list;
        this.dataCount = dataCount;
        this.totalDataCount = totalDataCount;
    }

    public List<AllOrdersByCustomerDto> getList() {
        return list;
    }

    public void setList(List<AllOrdersByCustomerDto> list) {
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
        return "PaginatedResponse{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                ", totalDataCount=" + totalDataCount +
                '}';
    }
}
