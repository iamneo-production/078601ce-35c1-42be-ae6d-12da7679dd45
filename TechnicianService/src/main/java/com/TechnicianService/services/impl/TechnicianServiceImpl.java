package com.TechnicianService.services.impl;

import com.TechnicianService.entities.InstallationData;
import com.TechnicianService.entities.Resources;
import com.TechnicianService.externals.InventoryService;
import com.TechnicianService.externals.TelecomOperationService;
import com.TechnicianService.repositories.InstalledRepo;
import com.TechnicianService.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnicianServiceImpl implements TechnicianService {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private TelecomOperationService telecomOperationService;
    @Override
    public List<Resources> faultyResource() {
        return this.inventoryService.getFaultyResources();
    }

    @Autowired
    private InstalledRepo installedRepo;
    @Override
    public boolean installationRequest(List<Resources> resourcesInstallation) {
        System.out.println(resourcesInstallation.toString());
            for(Resources s : resourcesInstallation){
                s.setResourceId(s.getResourceId());
                s.setResourceCondition(s.isResourceCondition());
                s.setResourceName(s.getResourceName());
                s.setResourceAllocationStatus(s.isResourceAllocationStatus());
                s.setInstallationStatus(true);
                s.setEmpId(s.getEmpId());
                s.setProjectName(s.getProjectName());
               // this.telecomOperationService.addResource(s);

            }
           for(Resources s : resourcesInstallation){
               InstallationData i = new InstallationData();
               i.setResourceName(s.getResourceName());
               i.setResourceId(s.getResourceId());
               //System.out.println("Installed item : "+s.getResourceName());
               this.installedRepo.save(i);
           }
           if(resourcesInstallation.size()==0) return false;
            return true;
    }

    @Override
    public List<InstallationData> getAll() {
        return this.installedRepo.findAll();
    }

    @Override
    public List<Resources> updateFault() {
        return this.faultyResource();
    }
}
