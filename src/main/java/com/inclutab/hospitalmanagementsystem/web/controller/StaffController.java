package com.inclutab.hospitalmanagementsystem.web.controller;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.dtos.UpdateStaffDto;
import com.inclutab.hospitalmanagementsystem.exceptions.HospitalManagementSystemException;
import com.inclutab.hospitalmanagementsystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    StaffService staffServiceImpl;


    @PostMapping("/")
    public ResponseEntity<?> addStaff(@RequestBody StaffDto staffDto){
        try {
            return new ResponseEntity<>(staffServiceImpl.addStaff(staffDto), HttpStatus.OK);
        }catch(HospitalManagementSystemException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateStaff(@RequestBody UpdateStaffDto updateStaffDto){
        try {
            return new ResponseEntity<>(staffServiceImpl.updateStaff(updateStaffDto), HttpStatus.OK);
        }catch(HospitalManagementSystemException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
