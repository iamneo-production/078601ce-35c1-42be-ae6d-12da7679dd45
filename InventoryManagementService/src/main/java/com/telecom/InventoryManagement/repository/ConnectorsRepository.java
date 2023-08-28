package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.InventoryManagement.entity.Connectors;

public interface ConnectorsRepository extends JpaRepository<Connectors, String>{

	List<Connectors> findByAllocation(String string);

}
