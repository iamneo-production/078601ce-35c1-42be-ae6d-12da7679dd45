package com.telecom.InventoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.InventoryManagement.entity.Connectors;
import com.telecom.InventoryManagement.entity.EthernetCable;
import com.telecom.InventoryManagement.entity.FibreOpticCable;
import com.telecom.InventoryManagement.entity.Laptop;
import com.telecom.InventoryManagement.entity.Modem;
import com.telecom.InventoryManagement.entity.Transivers;
import com.telecom.InventoryManagement.model.Item;
import com.telecom.InventoryManagement.model.ProjectTeam;
import com.telecom.InventoryManagement.model.Stock;
import com.telecom.InventoryManagement.service.InventoryService;

@RestController
@RequestMapping
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@PostMapping("/add/laptop")
	public Laptop saveLaptop(@RequestBody Laptop laptop) {
		return service.addLaptop(laptop);
	}
	
	@PostMapping("/add/connectors")
	public Connectors saveConnectors(@RequestBody Connectors connectors) {
		return service.addConnectors(connectors);
	}

	@PostMapping("/add/ethernetcable")
	public EthernetCable saveEthernetCable(@RequestBody EthernetCable ethernetCable) {
		return service.addEthernetCable(ethernetCable);
	}
	
	@PostMapping("/add/fibreopticcable")
	public FibreOpticCable saveFibreOpticCable(@RequestBody FibreOpticCable fibreOpticCable) {
		return service.addFibreOpticCable(fibreOpticCable);
	}
	
	@PostMapping("/add/modem")
	public Modem saveModem(@RequestBody Modem modem) {
		return service.addModem(modem);
	}
	
	@PostMapping("/add/transivers")
	public Transivers saveTransivers(@RequestBody Transivers transivers) {
		return service.addTransivers(transivers);
	}
	
	@PostMapping("/assertallocation")
	public Stock assertAllocation(@RequestBody ProjectTeam projectTeam) {
		return service.assertAllocation(projectTeam);
	}
	
	@GetMapping("/available-stock")
	public Stock availableStock() {
		return service.stockAvailable();
	}
	
	@GetMapping("/stock")
	public List<?> getStock(@RequestBody Item item){
		return service.availableStocks(item);
	}
}
