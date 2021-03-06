package com.inclutab.hospitalmanagementsystem.service;

import com.inclutab.hospitalmanagementsystem.data.dtos.StaffDto;
import com.inclutab.hospitalmanagementsystem.data.dtos.UpdateStaffDto;
import com.inclutab.hospitalmanagementsystem.data.model.Staff;
import com.inclutab.hospitalmanagementsystem.exceptions.IllegalStaffFieldException;
import com.inclutab.hospitalmanagementsystem.exceptions.StaffNotNullException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    void testThatStaffCannotBeNull(){
        StaffDto newStaff = null;
        assertThrows(StaffNotNullException.class, ()-> staffServiceImpl.addStaff(newStaff));
    }

    @Test
    void testThatStaffNameCannotBeEmpty(){
        StaffDto newStaff = new StaffDto();
        newStaff.setName("");
        assertThrows(IllegalStaffFieldException.class, ()-> staffServiceImpl.addStaff(newStaff));
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