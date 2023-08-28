package com.example.projectmanager.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanager.entity.ResourceAllocationRequest;
import com.example.projectmanager.repository.ResourceAllocationRequestRepository;

@Service
public class ResourceAllocationRequestService {

    @Autowired
    private ResourceAllocationRequestRepository requestRepository;

    public ResourceAllocationRequest createRequest(ResourceAllocationRequest request) {
        request.setStatus("pending");
        request.setRequestDate(LocalDateTime.now());
        return requestRepository.save(request);
    }

    public List<ResourceAllocationRequest> getRequestsByProjectId(Long projectId) {
        return requestRepository.findByProjectId(projectId);
    }

    // Other methods for updating and managing requests
}

