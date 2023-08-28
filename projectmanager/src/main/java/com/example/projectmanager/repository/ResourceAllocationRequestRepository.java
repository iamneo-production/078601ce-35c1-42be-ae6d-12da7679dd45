package com.example.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.entity.ResourceAllocationRequest;

@Repository
public interface ResourceAllocationRequestRepository extends JpaRepository<ResourceAllocationRequest, Long> {

    List<ResourceAllocationRequest> findByProjectId(Long projectId);
}

