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
public class EthernetCable {
	
	@Id
	private String ethernetCableId;
	private int length;
	private String allocation;
	private String category;
	private String projectTeam;

}
