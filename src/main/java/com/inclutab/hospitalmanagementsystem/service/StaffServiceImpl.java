package com.inclutab.hospitalmanagementsystem.service;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import com.inclutab.hospitalmanagementsystem.data.repository.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff addStaff(StaffDto staffDto) {
        ModelMapper modelMapper = new ModelMapper();
        Staff mappedStaff = modelMapper.map(staffDto, Staff.class);
        return staffRepository.save(mappedStaff);
    }
}
