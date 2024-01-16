package com.chinthaka.pointofsalesystem.controller;

import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;
import com.chinthaka.pointofsalesystem.dto.paginated.PaginatedGetAllCustomer;
import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;
import com.chinthaka.pointofsalesystem.service.CustomerService;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
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
                new StandardResponse(201, "Successfully", data), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-all-customer")
    public ResponseEntity<StandardResponse> getAllCustomer(){
        List<CustomerDto> customerDtos = customerService.getAllCustomer();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",customerDtos),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getCustomerById(
            @RequestParam(name = "id") Integer customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully", customerDto),HttpStatus.OK
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto){
        String data = customerService.updateCustomer(customerUpdateDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-status",params = {"status"})
    public ResponseEntity<StandardResponse> getByAllActiveStatus(@RequestParam(name = "status") boolean ActiveStatus){
        List<CustomerDto> data = customerService.getByAllActiveStatus(ActiveStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data),HttpStatus.OK);
    };

    @DeleteMapping(path = "/delete",params = {"id"})
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam(name = "id") Integer customerId){
        String data = customerService.deleteCustomer(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data),HttpStatus.OK);
    };

    @GetMapping(path = "filter-by-address-and-active-status",params = {"address","status"})
    public ResponseEntity<StandardResponse>  filterByAddress(
            @RequestParam(name = "address") String address, @RequestParam(name = "status") boolean status
    ){
        List<CustomerDto> data = customerService.filterByAddress(address,status);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",data),HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-customer-page",params = {"page","size"})
    public ResponseEntity<StandardResponse> getAllCustomer(
            @RequestParam(name = "page") int page, @RequestParam(name = "size") int size
    ){
        PaginatedGetAllCustomer paginatedGetAllCustomers = customerService
                .getAllCustomer(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",paginatedGetAllCustomers),HttpStatus.OK
        );
    }
}
