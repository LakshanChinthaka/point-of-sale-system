package com.chinthaka.pointofsalesystem.repo;

import com.chinthaka.pointofsalesystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findByActiveStatus(boolean activeStatus);

    boolean existsByNic(String nic);

    List<Customer> findByCustomerAddressIgnoreCaseAndActiveStatus(String address, boolean status);
}
