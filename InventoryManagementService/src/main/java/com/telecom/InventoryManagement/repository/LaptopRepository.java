package com.telecom.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telecom.InventoryManagement.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, String>{

	List<Laptop> findByAllocation(String string);
}
