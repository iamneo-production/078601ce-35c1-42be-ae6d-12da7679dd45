package com.hackathon.telecomOperationService.controller;

import com.hackathon.telecomOperationService.entities.ProjectDetails;
import com.hackathon.telecomOperationService.entities.Resources;
import com.hackathon.telecomOperationService.services.telecomOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hackathon.telecomOperationService.constraints.ConstantValues.resourcesListConstraint;

@RestController
@CrossOrigin("*")
public class telecomOperationController {
    @Autowired
    private telecomOperationService telecomOperationService;
    @PostMapping("/allocate/resource")
  //  @CircuitBreaker(name = "telecomOperationService",fallbackMethod = "inventoryCheckMethod")
    public ResponseEntity<?> allocateResource(@RequestBody ProjectDetails projectDetails){
        boolean flag = this.telecomOperationService.allocateResource(projectDetails);
        System.out.println("Inside controller "+flag);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    @GetMapping("/stock/update")
    public ResponseEntity<?>  stockUpdate(){
        List<String> l = this.telecomOperationService.stockUpdation();
        if(l.size()== 0) return new ResponseEntity<>("Stock health is good !",HttpStatus.OK);
        else return new ResponseEntity<>(l+" : need to be reStock",HttpStatus.OK);
    }
    @GetMapping("/resource/name/{resourceType}")
    public ResponseEntity<?> getResourceByName(@PathVariable String resourceType ){
        List<Resources> res = this.telecomOperationService.getResourceByName(resourceType);
        //if(res.size()==0) return new ResponseEntity<>("No resource Found of Type "+ resourceType,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Resource : "+ resourceType +" : available quantity is : "+res.size(),HttpStatus.OK);
    }
    @PostMapping("/add/resource")
    public ResponseEntity<?> createResource(@RequestBody Resources resources){
        boolean status = this.telecomOperationService.addResource(resources);
        return new ResponseEntity<>("Resource : " + resources.getResourceName() +" : added Successfully !",HttpStatus.OK);
    }
    @PostMapping("/repair/stock")
    public ResponseEntity<?> repairStock(){
        boolean f = this.telecomOperationService.repairResource();
        return new ResponseEntity<>("Stock repaired successfully ! : status : " +true,HttpStatus.OK);
    }
    @PutMapping("/update/resource/{resourceId}")
    public ResponseEntity<?> updateResource(@PathVariable Integer resourceId){
        boolean status = this.telecomOperationService.updateResource(resourceId);
        return new ResponseEntity<>("Updated successfully : status : " + status,HttpStatus.OK);
    }

//    public ResponseEntity<?> inventoryCheckMethod(ProjectDetails projectDetails, Exception ex) {
//
//
//        return new ResponseEntity<>("Inventory services are Unavailable,Try again", HttpStatus.OK);
//
//    }
}
