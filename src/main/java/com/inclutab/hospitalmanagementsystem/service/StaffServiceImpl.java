package com.inclutab.hospitalmanagementsystem.service;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.dtos.UpdateStaffDto;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import com.inclutab.hospitalmanagementsystem.data.repository.StaffRepository;
import com.inclutab.hospitalmanagementsystem.exceptions.StaffNotFoundException;
import com.inclutab.hospitalmanagementsystem.exceptions.StaffNotNullException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff addStaff(StaffDto staffDto) {
        if(staffDto == null){
            throw new StaffNotNullException("Staff cannot be null");
        }
        ModelMapper modelMapper = new ModelMapper();
        Staff mappedStaff = modelMapper.map(staffDto, Staff.class);
        return staffRepository.save(mappedStaff);
    }

    @Override
    public Staff updateStaff(UpdateStaffDto updateStaffDto) {

        Staff staff = staffRepository.findByUuid(updateStaffDto.getUuid());
        if (staff != null){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(updateStaffDto, staff);
            staffRepository.save(staff);
            return staff;
        }else{
            throw new StaffNotFoundException("Unauthorised Access");
        }
    }
}
