public class FieldRepository {


package com.virtusa.FieldTechnicianService.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

 

import com.virtusa.FieldTechnician.entity.FieldTechnician;

 

@Repository

public interface FieldTechnicianRepository extends JpaRepository<FieldTechnician,Integer> {


}

