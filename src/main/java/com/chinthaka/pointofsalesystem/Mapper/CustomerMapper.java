package com.chinthaka.pointofsalesystem.Mapper;

import com.chinthaka.pointofsalesystem.dto.CustomerDto;
import com.chinthaka.pointofsalesystem.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    Customer CustomerDtoToEntity(CustomerDto customerDto);
    CustomerDto EntityToCustomerDto(Customer customer);
}
