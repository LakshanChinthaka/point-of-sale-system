package com.chinthaka.pointofsalesystem.Mapper;

import com.chinthaka.pointofsalesystem.dto.Cutomer.CustomerDto;
import com.chinthaka.pointofsalesystem.dto.Cutomer.request.CustomerUpdateDto;
import com.chinthaka.pointofsalesystem.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    Customer customerDtoToEntity(CustomerDto customerDto);
    CustomerDto entityToCustomerDto(Customer customer);
    List<CustomerDto> entityListToCustomerDtoList(List<Customer> customers);
    List<Customer> customerListDtoToEntityList(List<CustomerDto> customerDtos);

    @Mapping(target = "activeStatus", ignore = true)
    void entityToUpdateCustomerDto(CustomerUpdateDto customerUpdateDto, @MappingTarget Customer customer);
    CustomerUpdateDto entityToUpdateCustomerDto(Customer customer);

    List<CustomerDto> pageCustomerToCustomerDto(Page<Customer> customers);
}
