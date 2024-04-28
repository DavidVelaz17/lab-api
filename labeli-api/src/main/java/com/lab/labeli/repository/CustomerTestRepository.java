package com.lab.labeli.repository;

import com.lab.labeli.entity.CustomerTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTestRepository extends JpaRepository<CustomerTest, Integer> {
    CustomerTest findByIdCustomers(Integer customerId);
}
