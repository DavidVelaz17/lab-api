package com.lab.labeli.repository;

import com.lab.labeli.entity.OrderTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTestRepository extends JpaRepository<OrderTest, Integer> {
    OrderTest findOrderTestByIdOrder(int idOrder);
}
