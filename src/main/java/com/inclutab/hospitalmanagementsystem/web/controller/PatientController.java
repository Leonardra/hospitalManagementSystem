package com.inclutab.hospitalmanagementsystem.web.controller;

import com.inclutab.hospitalmanagementsystem.data.dtos.DeleteForm;
import com.inclutab.hospitalmanagementsystem.exceptions.HospitalManagementSystemException;
import com.inclutab.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientServiceImpl;

    @GetMapping("/downloadCsv/{uuid}")
    public ResponseEntity<?> writeToCsv(@PathVariable String uuid, @RequestBody Long patientId){
        try {
            patientServiceImpl.writeToCsv(uuid, patientId);
            return new ResponseEntity<>("File download was successful, check inventory.csv in the program directory", HttpStatus.OK);
        }catch (IOException ex){
            return new ResponseEntity<>("Error processing request", HttpStatus.BAD_REQUEST);
        }catch(HospitalManagementSystemException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<?> findAllPatients(@PathVariable String uuid){
        try {
            return new ResponseEntity<>(patientServiceImpl.findAllPatients(uuid), HttpStatus.OK);
        }catch(HospitalManagementSystemException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteAll(@PathVariable String uuid, @RequestBody DeleteForm deleteForm){
        try {
            patientServiceImpl.deleteAll(uuid, deleteForm);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(HospitalManagementSystemException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
