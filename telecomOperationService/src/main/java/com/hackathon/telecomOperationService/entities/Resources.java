package com.hackathon.telecomOperationService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceId;
    private String resourceName;
    boolean resourceAllocationStatus;
    private boolean resourceCondition;
    private boolean installationStatus;
    private String empId;

    private String projectName;
}
