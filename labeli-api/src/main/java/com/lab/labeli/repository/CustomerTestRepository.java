package com.lab.labeli.repository;

import com.lab.labeli.entity.CustomerTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerTestRepository extends JpaRepository<CustomerTest, Integer> {
        List<CustomerTest> findAllByIdCustomers(Integer customerId);
}
