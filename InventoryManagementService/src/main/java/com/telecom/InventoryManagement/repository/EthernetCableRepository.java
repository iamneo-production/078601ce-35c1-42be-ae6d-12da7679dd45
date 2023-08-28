package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.InventoryManagement.entity.EthernetCable;

public interface EthernetCableRepository extends JpaRepository<EthernetCable, String>{

	List<EthernetCable> findByAllocation(String string);

}
