package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.InventoryManagement.entity.Transivers;

public interface TransiversRepository extends JpaRepository<Transivers, String>{

	List<Transivers> findByAllocation(String string);

}
