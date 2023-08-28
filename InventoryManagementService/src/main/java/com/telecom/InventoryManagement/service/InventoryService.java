package com.telecom.InventoryManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telecom.InventoryManagement.entity.Connectors;
import com.telecom.InventoryManagement.entity.EthernetCable;
import com.telecom.InventoryManagement.entity.FibreOpticCable;
import com.telecom.InventoryManagement.entity.Laptop;
import com.telecom.InventoryManagement.entity.Modem;
import com.telecom.InventoryManagement.entity.Transivers;
import com.telecom.InventoryManagement.model.Item;
import com.telecom.InventoryManagement.model.ProjectTeam;
import com.telecom.InventoryManagement.model.Stock;

@Service
public interface InventoryService {
	
	public Laptop addLaptop(Laptop laptop);
	public Connectors addConnectors(Connectors connectors);
	public EthernetCable addEthernetCable(EthernetCable ethernetCable);
	public FibreOpticCable addFibreOpticCable(FibreOpticCable fibreOpticCable);
	public Modem addModem(Modem modem);
	public Transivers addTransivers(Transivers transivers);
	public Stock assertAllocation(ProjectTeam projectTeam);
	public Stock stockAvailable();
	public List<?> availableStocks(Item item);

}
