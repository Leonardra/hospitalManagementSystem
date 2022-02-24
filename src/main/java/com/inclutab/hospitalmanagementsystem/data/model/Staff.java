package com.inclutab.hospitalmanagementsystem.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String uuid;
    @CreationTimestamp
    private LocalDate registrationDate;

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }
}
