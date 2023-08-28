package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.InventoryManagement.entity.FibreOpticCable;

public interface FibreOpticCableRepository extends JpaRepository<FibreOpticCable, String>{

	List<FibreOpticCable> findByAllocation(String string);

}
