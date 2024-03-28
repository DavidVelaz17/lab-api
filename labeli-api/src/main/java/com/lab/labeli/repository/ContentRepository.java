package com.lab.labeli.repository;
import com.lab.labeli.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Contents, Integer>{
}
