package com.chinthaka.pointofsalesystem.repo;

import com.chinthaka.pointofsalesystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
