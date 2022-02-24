package com.inclutab.hospitalmanagementsystem.data.repository;

import com.inclutab.hospitalmanagementsystem.data.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(
            "delete from Patient where lastVisitDate between :from and :to"
    )
    void deleteAll(@Param("from") String from, @Param("to") String to);
}

