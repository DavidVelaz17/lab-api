package com.lab.labeli.repository;

import com.lab.labeli.entity.TestContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface TestContentsRepository extends JpaRepository<TestContents, Integer>{
}
