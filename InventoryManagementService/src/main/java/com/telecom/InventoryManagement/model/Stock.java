package com.telecom.InventoryManagement.model;

import java.util.List;

import com.telecom.InventoryManagement.entity.Connectors;
import com.telecom.InventoryManagement.entity.EthernetCable;
import com.telecom.InventoryManagement.entity.FibreOpticCable;
import com.telecom.InventoryManagement.entity.Laptop;
import com.telecom.InventoryManagement.entity.Modem;
import com.telecom.InventoryManagement.entity.Transivers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	
	private String projectTeam;
	private List<Laptop> laptops;
	private List<Modem> modems;
	private List<EthernetCable> ethernetCables;
	private List<FibreOpticCable> fibreOpticCables;
	private List<Connectors> connectors;
	private List<Transivers> transivers;

}
