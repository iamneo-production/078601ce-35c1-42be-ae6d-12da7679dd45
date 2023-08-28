package com.virtusa.FieldTechnicianService.controller;

 

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.resilience4j.retry.annotation.Retry;
import com.virtusa.FieldTechnicianService.entity.FieldTechnician;

import com.virtusa.FieldTechnicianService.entity.Notification;
import com.virtusa.FieldTechnicianService.repository.PatientRepository;
import com.virtusa.FieldTechnicianService.feign.DoctorFeignClient;
import com.virtusa.FieldTechnicianService.feign.NotificationFeignClient;

 

@RestController
public class FieldTechnicianController {

 

    @Autowired
    FieldTechnicianRepository FieldTechnicianRepository;

 

    @Autowired
    FieldTechnicianFeignClient FieldTechnicianFeignClient;

 

    @Autowired
    NotificationFeignClient notificationClient;

 

    @PostMapping("/fieldtechnicians")
    public void createFieldTechnicians(@RequestBody FieldTechnician fieldtechnicians){
        fieldtechniciansRepository.save(fieldtechnicians);
    }

    

 

    
    @GetMapping("/fieldtechnicians/notifications/{fieldtechnicianId}")
    @Retry(name="notification", fallbackMethod="notificationFallback")
    public List<Notification> getNotifications(@PathVariable("fieldTechnicianId") int pid){
        return notificationClient.notifications(pid);
    }

 

    public List<Notification> notificationFallback(){
        List<Notification> notifys=new ArrayList<>();
        Notification n=new Notification(0,"field service is down",0,"fall back route enabled");
        notifys.add(n);
        return notifys;
    }

 

}