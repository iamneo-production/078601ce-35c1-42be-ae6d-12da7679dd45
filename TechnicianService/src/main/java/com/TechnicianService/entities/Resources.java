package com.TechnicianService.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Resources {
    @Id
    private int resourceId;
    private String resourceName;
    boolean resourceAllocationStatus;
    private boolean resourceCondition;
    private boolean installationStatus;
    private String empId;

    private String projectName;
}
