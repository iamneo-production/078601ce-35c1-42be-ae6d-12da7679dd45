package com.TechnicianService.externals;

import com.TechnicianService.entities.Resources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryService {
    @GetMapping("/faulty/resources")
    List<Resources> getFaultyResources();
}
