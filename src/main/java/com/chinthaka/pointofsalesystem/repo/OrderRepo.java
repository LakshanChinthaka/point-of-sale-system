package com.chinthaka.pointofsalesystem.repo;

import com.chinthaka.pointofsalesystem.dto.query.GetOrderDetailsByCustomer;
import com.chinthaka.pointofsalesystem.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT po.order_id AS orderID, po.order_data AS orderData, od.amount AS amount," +
            " od.qyt AS balanceQyt, od.item_name AS itemName " +
            "FROM purchase_order po " +
            "JOIN order_details od ON po.order_id = od.order_id  " +
            "WHERE po.customer_id = :customerId", nativeQuery = true)
    List<GetOrderDetailsByCustomer> getOrderDetailsByCustomers(Integer customerId, Pageable pageable);

}
