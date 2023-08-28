package com.hackathon.telecomOperationService.externals;

import com.hackathon.telecomOperationService.entities.ProjectDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryService {
    @GetMapping("/inventory/availability")
    int isStockAvailable(ProjectDetails projectDetails);
}
