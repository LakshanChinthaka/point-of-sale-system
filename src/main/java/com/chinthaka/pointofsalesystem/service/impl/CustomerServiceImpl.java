package com.chinthaka.pointofsalesystem.service.impl;

import com.chinthaka.pointofsalesystem.Mapper.CustomerMapper;
import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllCustomer;
import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;
import com.chinthaka.pointofsalesystem.entity.Customer;
import com.chinthaka.pointofsalesystem.exception.NotFoundException;
import com.chinthaka.pointofsalesystem.exception.UserAlreadyExistException;
import com.chinthaka.pointofsalesystem.exception.ValidationException;
import com.chinthaka.pointofsalesystem.repo.CustomerRepo;
import com.chinthaka.pointofsalesystem.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
            if (!customerRepo.existsByNic(customerDto.getNic())) {
                Customer customer = customerMapper.customerDtoToEntity(customerDto);
                customerRepo.save(customer);
                return customer.getCustomerName() + " Successfully Saved.";
            } else {
                throw new UserAlreadyExistException(
                        customerDto.getCustomerName() + " Already Exist.");
            }
        } else {
            throw new UserAlreadyExistException(
                    customerDto.getCustomerName() + " Already Exist.");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> getAllCustomer = customerRepo.findAll();
        if (!getAllCustomer.isEmpty()) {
            return customerMapper.entityListToCustomerDtoList(getAllCustomer);
        } else {
            throw new NotFoundException("No found customers");
        }
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.findById(customerId).get();
            return customerMapper.entityToCustomerDto(customer);
        } else {
            throw new NotFoundException("Customer Id - " + customerId + " Not Found");
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (customerRepo.existsById(customerUpdateDto.getCustomerID())) {
            final Customer customer = customerRepo.findById(customerUpdateDto.getCustomerID()).get();
            customerMapper.entityToUpdateCustomerDto(customerUpdateDto, customer);
            customerRepo.save(customer);
            return "Customer Id - " + customerUpdateDto.getCustomerID() + " Update Successfully";
        } else {
            throw new NotFoundException("Customer Id - " + customerUpdateDto.getCustomerID() + " Not found");
        }
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        if (customerRepo.existsById(customerId)) {
            final Customer customer = customerRepo.findById(customerId).get();
            customer.setActiveStatus(false);
            customerRepo.save(customer);
            return "Customer Id - " + customerId + " Successfully deleted";
        } else {
            throw new NotFoundException("Customer Id - " + customerId + " Not found");
        }
    }

    @Override
    public List<CustomerDto> getByAllActiveStatus(boolean activeStatus) {
        List<Customer> customers = customerRepo.findByActiveStatus(activeStatus);
        if (!customers.isEmpty()) {
            return customerMapper.entityListToCustomerDtoList(customers);
        } else {
            throw new NotFoundException("No found customers");
        }
    }

    @Override
    public List<CustomerDto> filterByAddress(String address, boolean status) {
        if (!address.isEmpty()) {
            final List<Customer> customer = customerRepo.findByCustomerAddressIgnoreCaseAndActiveStatus(address,status);
           if (!customer.isEmpty()){
               return customerMapper.entityListToCustomerDtoList(customer);
           }else {
               throw new NotFoundException("Customer Not Found");
           }
        } else {
            throw new ValidationException("Cannot be address empty");
        }

    }

    @Override
    public PaginatedGetAllCustomer getAllCustomer(int page, int size) {
        Page<Customer> customers = customerRepo.findAll(PageRequest.of(page,size));
        if (!customers.isEmpty()){
            return new PaginatedGetAllCustomer(
                    customerMapper.pageCustomerToCustomerDto(customers),
                    customers.getNumberOfElements(),
                    customers.getTotalElements()
            );
        }else {
            throw new NotFoundException("No Data");
        }
    }
}
