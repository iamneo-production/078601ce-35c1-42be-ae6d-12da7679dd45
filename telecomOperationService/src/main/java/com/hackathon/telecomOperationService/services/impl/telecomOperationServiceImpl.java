package com.hackathon.telecomOperationService.services.impl;

import com.hackathon.telecomOperationService.entities.ProjectDetails;
import com.hackathon.telecomOperationService.entities.Resources;
import com.hackathon.telecomOperationService.externals.InventoryService;
import com.hackathon.telecomOperationService.externals.TechnicianService;
import com.hackathon.telecomOperationService.repository.ResourceRepo;
import com.hackathon.telecomOperationService.services.telecomOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.hackathon.telecomOperationService.constraints.ConstantValues.resourcesListConstraint;

@Service
public class telecomOperationServiceImpl implements telecomOperationService {
    @Autowired
    private ResourceRepo resourceRepo;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private TechnicianService technicianService;
    @Override
    public boolean allocateResource(ProjectDetails projectDetails) {
        List<String> resourceList =  projectDetails.getResourceList();
        //send request to check is stock available to inventory team
        int size = projectDetails.getTeamMembers().size();
        System.out.println("Team member size :: "+ size);
        int i = 0;
        boolean flag=false;
        int resourceSize = resourceList.size();
        List<Resources> updateAllocationStatus = new ArrayList<>();
        while(i<size)
        {

            int count = this.inventoryService.isStockAvailable(projectDetails);
            System.out.println();
            System.out.println("Count : "+ count);
            flag = false;
            //if available
            List<Resources> installation = new ArrayList<>();
            // send details to Technician teams for installation
            if(count==resourceSize)
            {
                //System.out.println("Count : "+ count);
                for (String s : resourceList)
                {
                    List<Resources> resourceslist = this.resourceRepo.findByResourceName(s);
                    //System.out.println(resourceslist.toString());
                    for (Resources assign : resourceslist)
                    {
                        if (!assign.isResourceAllocationStatus())
                        {
                            assign.setResourceAllocationStatus(true);
                            assign.setResourceId(assign.getResourceId());
                            assign.setResourceName(assign.getResourceName());
                            assign.setInstallationStatus(true);
                            assign.setEmpId(projectDetails.getTeamMembers().get(i));
                            assign.setProjectName(projectDetails.getProjectName());
                            updateAllocationStatus.add(assign);
//                            this.resourceRepo.save(assign);
                            installation.add(assign);
                            break;

                        }
                    }

                }

            }
            i++;
           if(count==resourceSize){
               flag = this.technicianService.installationRequest(installation);
               System.out.println("Value for flag : "+flag);
           }

        }
        System.out.println("Outside  loop:"+flag);
        if(flag){
            for(Resources s : updateAllocationStatus){
                this.resourceRepo.save(s);
            }
            return true;
        }
        return false;
    }
    @Override
    public List<String>  stockUpdation() {

        List<String> l = new ArrayList<>();
        for(String  rlc : resourcesListConstraint ){
            int count = 0;
            List<Resources> listOfresource = this.resourceRepo.findByResourceName(rlc);
            for(Resources s : listOfresource){
                if(!s.isResourceAllocationStatus() && s.isResourceCondition()){
                    count++;
                }
            }
            if(count < 2 ) {
                l.add(rlc);

            }
        }
        return l ;
    }

    @Override
    public List<Resources> getResourceByName(String resourceType) {
        List<Resources> resourcesByNameList = this.resourceRepo.findByResourceName(resourceType);
        List<Resources> finalList = resourcesByNameList.stream().filter((s)-> !s.isResourceAllocationStatus() && s.isResourceCondition()).toList();
        return finalList;
    }

    @Override
    public boolean addResource(Resources resources) {
        Resources saveRes = new Resources();
        saveRes.setResourceName(resources.getResourceName());
        saveRes.setResourceAllocationStatus(false);
        saveRes.setResourceCondition(resources.isResourceCondition());
        saveRes.setInstallationStatus(false);
        saveRes.setEmpId("");
        saveRes.setProjectName("");
        this.resourceRepo.save(saveRes);
        return true;
    }

    @Override
    public boolean repairResource() {
        List<Resources> updateResource=this.technicianService.updateFault();
        for(Resources s : updateResource){
            s.setResourceId(s.getResourceId());
            s.setResourceName(s.getResourceName());
            s.setResourceCondition(true);
            s.setProjectName(s.getProjectName());
            s.setResourceAllocationStatus(s.isResourceAllocationStatus());
            s.setEmpId(s.getEmpId());
            s.setInstallationStatus(s.isInstallationStatus());
            this.resourceRepo.save(s);

        }
        return true;
    }

    @Override
    public boolean updateResource(int resourceId) {
        Resources ss = this.resourceRepo.findById(resourceId).get();
        Resources s = new Resources();
        s.setResourceId(ss.getResourceId());
        s.setResourceName(ss.getResourceName());
        s.setResourceCondition(false);
        s.setProjectName(ss.getProjectName());
        s.setResourceAllocationStatus(ss.isResourceAllocationStatus());
        s.setEmpId(ss.getEmpId());
        s.setInstallationStatus(ss.isInstallationStatus());
        this.resourceRepo.save(s);
        return true;
    }
}
