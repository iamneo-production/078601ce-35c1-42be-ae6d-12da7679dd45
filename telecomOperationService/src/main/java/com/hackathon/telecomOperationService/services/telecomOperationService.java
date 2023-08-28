package com.hackathon.telecomOperationService.services;

import com.hackathon.telecomOperationService.entities.ProjectDetails;
import com.hackathon.telecomOperationService.entities.Resources;

import java.util.List;

public interface telecomOperationService {
    boolean allocateResource(ProjectDetails projectDetails);
    List<String> stockUpdation();
    List<Resources> getResourceByName(String resourceType);
    boolean addResource(Resources resources);

    boolean repairResource();
    boolean updateResource(int id);

    //update

}
