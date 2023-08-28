package com.example.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanager.entity.ResourceAllocationRequest;
import com.example.projectmanager.service.ResourceAllocationRequestService;

@RestController
@RequestMapping("/resource-allocation")
public class ResourceAllocationRequestController {

    @Autowired
    private ResourceAllocationRequestService requestService;

    @PostMapping("/request")
    public ResponseEntity<ResourceAllocationRequest> requestResourceAllocation(@RequestBody ResourceAllocationRequest request) {
        ResourceAllocationRequest createdRequest = requestService.createRequest(request);
        return ResponseEntity.ok(createdRequest);
    }

    @GetMapping("/requests/{projectId}")
    public ResponseEntity<List<ResourceAllocationRequest>> getRequestsByProjectId(@PathVariable Long projectId) {
        List<ResourceAllocationRequest> requests = requestService.getRequestsByProjectId(projectId);
        return ResponseEntity.ok(requests);
    }

    
}

