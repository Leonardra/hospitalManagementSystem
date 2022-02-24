package com.inclutab.hospitalmanagementsystem.service;


import com.inclutab.hospitalmanagementsystem.data.model.Patient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PatientService {
    void writeToCsv(String uuid, Long patientId) throws IOException;
    List<Patient> findAllPatients(String uuid);
    void deleteAll(String uuid, String from, String to);
}
