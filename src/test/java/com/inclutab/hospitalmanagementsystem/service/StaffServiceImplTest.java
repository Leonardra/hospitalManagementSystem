package com.inclutab.hospitalmanagementsystem.service;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.dtos.UpdateStaffDto;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Slf4j
class StaffServiceImplTest {

    @Autowired
    StaffService staffServiceImpl;

    @Test
    void testThatStaffCanBeAdded(){
        StaffDto newStaff = new StaffDto();
        newStaff.setName("Adefemi");
        Staff savedStaff = staffServiceImpl.addStaff(newStaff);
        log.info("Staff after saving ->{}", savedStaff);
        assertThat(savedStaff.getId()).isNotNull();
    }


    @Test
    void testThatStaffUUIDIsSetBeforeSaving(){
        StaffDto newStaff = new StaffDto();
        newStaff.setName("Adefemi");
        Staff savedStaff = staffServiceImpl.addStaff(newStaff);
        log.info("Staff after saving ->{}", savedStaff);
        assertThat(savedStaff.getUuid()).isNotNull();
    }


    @Test
    void TestThatStaffCanBeUpdated(){
        StaffDto newStaff = new StaffDto();
        newStaff.setName("Adefemi");
        Staff savedStaff = staffServiceImpl.addStaff(newStaff);
        log.info("Staff after saving ->{}", savedStaff);

        UpdateStaffDto updateStaffDto = new UpdateStaffDto();
        updateStaffDto.setName("Adeola");
        updateStaffDto.setUuid(savedStaff.getUuid());

        Staff updatedStaff = staffServiceImpl.updateStaff(updateStaffDto);
        log.info("Staff after updating ->{}", updatedStaff);
        assertThat(updatedStaff.getName()).isEqualTo("Adeola");
    }
}