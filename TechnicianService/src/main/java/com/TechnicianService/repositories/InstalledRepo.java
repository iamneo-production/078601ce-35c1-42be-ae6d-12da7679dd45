package com.TechnicianService.repositories;

import com.TechnicianService.entities.InstallationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstalledRepo extends JpaRepository<InstallationData,Integer> {
}
