package com.hackathon.telecomOperationService.externals;

import com.hackathon.telecomOperationService.entities.Resources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "TECHNICIAN-SERVICE")
public interface TechnicianService {
    @PostMapping("/Installation/status")
    boolean installationRequest(@RequestBody List<Resources> resourcesInstallation);

    @PostMapping("/repair/fault")
    List<Resources> updateFault();
}
