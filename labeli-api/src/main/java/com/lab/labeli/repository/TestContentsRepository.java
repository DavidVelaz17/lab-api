package com.lab.labeli.repository;

import com.lab.labeli.entity.TestContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestContentsRepository extends JpaRepository<TestContents, Integer>{
    List<TestContents> findAllByTestsId(Integer testsId);
}
