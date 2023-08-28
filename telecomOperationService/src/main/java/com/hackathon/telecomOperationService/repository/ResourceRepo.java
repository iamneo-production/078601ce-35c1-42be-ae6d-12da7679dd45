package com.hackathon.telecomOperationService.repository;

import com.hackathon.telecomOperationService.entities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepo extends JpaRepository<Resources,Integer> {
    List<Resources> findByResourceName(String resourceName);
}
