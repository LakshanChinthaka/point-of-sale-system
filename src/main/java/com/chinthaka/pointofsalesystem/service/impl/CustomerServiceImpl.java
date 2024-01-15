package com.chinthaka.pointofsalesystem.service.impl;

import com.chinthaka.pointofsalesystem.Mapper.CustomerMapper;
import com.chinthaka.pointofsalesystem.dto.CustomerDto;
import com.chinthaka.pointofsalesystem.entity.Customer;
import com.chinthaka.pointofsalesystem.exception.UserAlreadyExistException;
import com.chinthaka.pointofsalesystem.repo.CustomerRepo;
import com.chinthaka.pointofsalesystem.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        if (!customerRepo.existsById(customerDto.getCustomerID())) {
            Customer customer = customerMapper.CustomerDtoToEntity(customerDto);
            customerRepo.save(customer);
            return "Customer Id - " + customer.getCustomerID() + "Successfully Saved.";
        }else {
            throw new UserAlreadyExistException(
                    "Customer Id - " + customerDto.getCustomerID() + "Already Exist.");
        }
    }
}
