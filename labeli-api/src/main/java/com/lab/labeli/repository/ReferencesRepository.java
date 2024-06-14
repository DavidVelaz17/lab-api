package com.lab.labeli.repository;

import com.lab.labeli.entity.References;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferencesRepository extends JpaRepository<References, Integer> {
    List<References> findAllByContentId(Integer idContent);
}
