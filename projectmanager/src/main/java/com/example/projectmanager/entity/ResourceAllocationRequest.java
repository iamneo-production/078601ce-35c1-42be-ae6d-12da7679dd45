package com.example.projectmanager.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ResourceAllocationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long projectId;
    private String resourceType;
    private int quantityRequested;
    private LocalDateTime requestDate;
    private String status;
    private LocalDateTime allocationDate;
    private int allocatedQuantity;
    private Long allocatedAssetId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProjectId() {
        return projectId;
    }
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
    public int getQuantityRequested() {
        return quantityRequested;
    }
    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }
    public LocalDateTime getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getAllocationDate() {
        return allocationDate;
    }
    public void setAllocationDate(LocalDateTime allocationDate) {
        this.allocationDate = allocationDate;
    }
    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }
    public void setAllocatedQuantity(int allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }
    public Long getAllocatedAssetId() {
        return allocatedAssetId;
    }
    public void setAllocatedAssetId(Long allocatedAssetId) {
        this.allocatedAssetId = allocatedAssetId;
    }


    
    
}

