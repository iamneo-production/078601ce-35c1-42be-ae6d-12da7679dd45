package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.InventoryManagement.entity.Modem;

public interface ModemRepository extends JpaRepository<Modem, String>{

	List<Modem> findByAllocation(String string);

}
