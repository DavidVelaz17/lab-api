package com.lab.labeli.repository;

import com.lab.labeli.entity.Result;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findAllByIdCustomers(Integer customerId);
    @Transactional
    void deleteByIdTests(Integer testId);
}
