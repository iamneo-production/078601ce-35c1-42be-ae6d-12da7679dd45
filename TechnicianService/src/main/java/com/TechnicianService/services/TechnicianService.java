package com.TechnicianService.services;

import com.TechnicianService.entities.InstallationData;
import com.TechnicianService.entities.Resources;
import java.util.*;
public interface TechnicianService {
    List<Resources> faultyResource();
    boolean installationRequest(List<Resources> resourcesInstallation);
    List<InstallationData> getAll();
    List<Resources> updateFault();
}
