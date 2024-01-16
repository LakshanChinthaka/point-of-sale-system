package com.chinthaka.pointofsalesystem.service;

import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllCustomer;
import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    CustomerDto getCustomerById(Integer customerId);

    String updateCustomer(CustomerUpdateDto customerUpdateDto);

    String deleteCustomer(Integer customerId);

    List<CustomerDto> getByAllActiveStatus(boolean activeStatus);

    List<CustomerDto> filterByAddress(String address, boolean status);

    PaginatedGetAllCustomer getAllCustomer(int page, int size);
}
