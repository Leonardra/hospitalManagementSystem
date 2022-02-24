package com.inclutab.hospitalmanagementsystem.service;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.dtos.UpdateStaffDto;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import org.springframework.stereotype.Service;


@Service
public interface StaffService {
    Staff addStaff(StaffDto staffDto);
    Staff updateStaff(UpdateStaffDto updateStaffDto);
}
