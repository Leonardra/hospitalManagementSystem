package com.inclutab.hospitalmanagementsystem.service;


import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PatientService {
    void writeToCsv(String uuid, Long patientId) throws IOException;
}
