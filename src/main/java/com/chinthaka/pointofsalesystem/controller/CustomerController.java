package com.chinthaka.pointofsalesystem.controller;

import com.chinthaka.pointofsalesystem.dto.CustomerDto;
import com.chinthaka.pointofsalesystem.service.CustomerService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
        String data = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Save Successfully", data), HttpStatus.CREATED);
    }

}
