package com.lab.labeli.repository;

import com.lab.labeli.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByIdCustomers(Integer customerId);
}
