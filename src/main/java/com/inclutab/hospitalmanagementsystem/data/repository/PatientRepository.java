package com.inclutab.hospitalmanagementsystem.data.repository;

import com.inclutab.hospitalmanagementsystem.data.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(
            "delete from Patient where lastVisitDate between :from and :to"
    )
    @Modifying
    @Transactional
    void deleteAll(@Param("from") LocalDate from, @Param("to") LocalDate to);
}

