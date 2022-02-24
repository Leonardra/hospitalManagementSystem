package com.inclutab.hospitalmanagementsystem.service;


import com.inclutab.hospitalmanagementsystem.data.dtos.DeleteForm;
import com.inclutab.hospitalmanagementsystem.data.model.Patient;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import com.inclutab.hospitalmanagementsystem.data.repository.PatientRepository;
import com.inclutab.hospitalmanagementsystem.data.repository.StaffRepository;
import com.inclutab.hospitalmanagementsystem.exceptions.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public void writeToCsv(String uuid, Long patientId) throws IOException {
        Staff staff = staffRepository.findByUuid(uuid);

        if(staff != null){
            Optional<Patient> optionalPatient = patientRepository.findById(patientId);
            if(optionalPatient.isPresent()){
                Patient patient = optionalPatient.get();

                File csvFile = new File("inventory.csv");
                if(!csvFile.exists()) {
                    boolean newFile = csvFile.createNewFile();
                }

                try (PrintWriter pw = new PrintWriter(csvFile)) {
                    String  patientRow = patient.toCsvRow();
                    pw.println(patientRow);
                }
            }
        }else{
            throw new StaffNotFoundException("Unauthorised Access");
        }
    }

    @Override
    public List<Patient> findAllPatients(String uuid) {
        Staff staff = staffRepository.findByUuid(uuid);

        if(staff != null){
            List<Patient> patients = patientRepository.findAll();
            return patients
                    .stream()
                    .filter(e -> LocalDate.now().getYear() - e.getLastVisitDate().getYear() > 2)
                    .collect(Collectors.toList());
        }else{
            throw new StaffNotFoundException("Unauthorised Access");
        }
    }

    @Override
    public void deleteAll(String uuid, DeleteForm deleteForm) {
        Staff staff = staffRepository.findByUuid(uuid);
        if(staff != null){
            patientRepository.deleteAll(deleteForm.getFrom(), deleteForm.getTo());
        }else{
            throw new StaffNotFoundException("Unauthorised Access");
        }
    }
}
