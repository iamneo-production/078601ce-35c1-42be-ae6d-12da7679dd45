package com.telecom.InventoryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
	
	@Id
	private String laptopId;
	private String laptopModel;
	private String allocation;
	private String status;
	private String category;
	private String projectTeam;

}
