package com.lab.labeli.repository;

import com.lab.labeli.entity.ContentsResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContentsResultsRepository extends JpaRepository<ContentsResults, Integer>{
}
