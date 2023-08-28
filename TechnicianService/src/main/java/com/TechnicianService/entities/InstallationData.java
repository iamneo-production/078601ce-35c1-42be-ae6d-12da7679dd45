package com.TechnicianService.entities;

import jakarta.persistence.*;
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
public class InstallationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int installationId;
    private int resourceId;
    private String resourceName;

}
