package com.hackathon.telecomOperationService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProjectDetails {

    private int projectId;

    private String projectName;

    private List<String> resourceList;
    private boolean isResourceAllocated;
    private List<String> teamMembers;
}
