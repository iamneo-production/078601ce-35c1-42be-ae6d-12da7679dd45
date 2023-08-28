package com.TechnicianService.controllers;

import com.TechnicianService.entities.InstallationData;
import com.TechnicianService.entities.Resources;
import com.TechnicianService.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TechnicianControllers {
    @Autowired
    private TechnicianService technicianService;
    @GetMapping("/getFaultyResources")
    public ResponseEntity<?> faultyResource(){
        List<Resources> faultyresourcesList =this.technicianService.faultyResource();
        return new ResponseEntity<>(faultyresourcesList, HttpStatus.OK);
    }
    @PostMapping("/Installation/status")
    public ResponseEntity<?> installationStatus(@RequestBody List<Resources> resources){
        boolean flag =this.technicianService.installationRequest(resources);
        return new ResponseEntity<>(flag,HttpStatus.OK);
    }
    @GetMapping("/getAllInstalled/resources")
    public ResponseEntity<?> getAllInstalled(){
        List<InstallationData> installationDataList =this.technicianService.getAll();
        return new ResponseEntity<>(installationDataList, HttpStatus.OK);
    }

    //getting the fault to be a good condition
    @PostMapping("/repair/fault")
    public ResponseEntity<?> updateFault(){
        List<Resources> faultyresourcesList =this.technicianService.updateFault();
        return new ResponseEntity<>(faultyresourcesList, HttpStatus.OK);
    }
}
