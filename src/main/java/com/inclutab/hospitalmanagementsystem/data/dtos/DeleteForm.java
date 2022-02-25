package com.inclutab.hospitalmanagementsystem.data.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeleteForm {
    private LocalDate from;
    private LocalDate to;
}
