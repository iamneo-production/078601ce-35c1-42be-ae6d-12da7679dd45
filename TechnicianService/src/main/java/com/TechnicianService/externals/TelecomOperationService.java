package com.TechnicianService.externals;

import com.TechnicianService.entities.Resources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("TELECOM-SERVICE")
public interface TelecomOperationService {
    @GetMapping("/resource/name/{resourceType}")
    List<Resources> getResourceByName(@PathVariable String resourceType);

    @PostMapping("/add/resource")
    boolean addResource(Resources resources);
}
