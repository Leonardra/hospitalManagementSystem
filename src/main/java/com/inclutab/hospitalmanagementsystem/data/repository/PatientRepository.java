package com.inclutab.hospitalmanagementsystem.data.repository;

import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Staff, Long> {
}
