package com.telecom.InventoryManagement.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.telecom.InventoryManagement.model.employee;
import com.telecom.InventoryManagement.repository.ConnectorsRepository;
import com.telecom.InventoryManagement.repository.EthernetCableRepository;
import com.telecom.InventoryManagement.repository.FibreOpticCableRepository;
import com.telecom.InventoryManagement.repository.LaptopRepository;
import com.telecom.InventoryManagement.repository.ModemRepository;
import com.telecom.InventoryManagement.repository.TransiversRepository;
import com.telecom.InventoryManagement.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Autowired
	private ConnectorsRepository connectorsRepository;
	
	@Autowired
	private EthernetCableRepository ethernetCableRepository;
	
	@Autowired
	private FibreOpticCableRepository fibreOpticCableRepository;
	
	@Autowired
	private ModemRepository modemRepository;
	
	@Autowired
	private TransiversRepository transiversRepository;

	@Override
	public Laptop addLaptop(Laptop laptop) {
		
		return laptopRepository.save(laptop);
	}

	@Override
	public Connectors addConnectors(Connectors connectors) {
		return connectorsRepository.save(connectors);
	}

	@Override
	public EthernetCable addEthernetCable(EthernetCable ethernetCable) {
		return ethernetCableRepository.save(ethernetCable);
	}

	@Override
	public FibreOpticCable addFibreOpticCable(FibreOpticCable fibreOpticCable) {
		return fibreOpticCableRepository.save(fibreOpticCable);
	}

	@Override
	public Modem addModem(Modem modem) {
		return modemRepository.save(modem);
	}

	@Override
	public Transivers addTransivers(Transivers transivers) {
		return transiversRepository.save(transivers);
	}

	@Override
	public Stock assertAllocation(ProjectTeam projectTeam) {
		List<employee> projectMembers = projectTeam.getProjectMembers();
		Stock freeStock=new Stock();
		freeStock.setLaptops(laptopRepository.findByAllocation("notallocated"));
		freeStock.setConnectors(connectorsRepository.findByAllocation("notallocated"));
		freeStock.setEthernetCables(ethernetCableRepository.findByAllocation("notallocated"));
		freeStock.setFibreOpticCables(fibreOpticCableRepository.findByAllocation("notallocated"));
		freeStock.setModems(modemRepository.findByAllocation("notallocated"));
		freeStock.setTransivers(transiversRepository.findByAllocation("notallocated"));
		//System.out.println(freeStock);
		if((freeStock.getConnectors().size()<projectMembers.size())||(freeStock.getEthernetCables().size()<projectMembers.size())||(freeStock.getFibreOpticCables().size()<projectMembers.size())||(freeStock.getLaptops().size()<projectMembers.size())||(freeStock.getModems().size()<projectMembers.size())||(freeStock.getTransivers().size()<projectMembers.size())) {
			throw new RuntimeException("stock not available");
		}
		List<Connectors> allocatedConnectors=new ArrayList<>();
		List<EthernetCable> allocatedEthernetCables=new ArrayList<>();
		List<FibreOpticCable> allocatedFibreOpticCables=new ArrayList<>();
		List<Laptop> allocatedLaptops=new ArrayList<>();
		List<Modem> allocatedModems=new ArrayList<>();
		List<Transivers> allocatedTransivers=new ArrayList<>();
		for(employee member:projectMembers) {
			
			Connectors firstConnector= freeStock.getConnectors().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new Connectors());
			firstConnector.setAllocation(member.getEmployeeId());
			firstConnector.setProjectTeam(projectTeam.getProjectName());
			connectorsRepository.save(firstConnector);
			allocatedConnectors.add(firstConnector);
				
			EthernetCable firstEthernetCable=freeStock.getEthernetCables().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new EthernetCable());
			firstEthernetCable.setAllocation(member.getEmployeeId());
			firstEthernetCable.setProjectTeam(projectTeam.getProjectName());
			ethernetCableRepository.save(firstEthernetCable);
			allocatedEthernetCables.add(firstEthernetCable);
			
			FibreOpticCable firstFibreOpticCable=freeStock.getFibreOpticCables().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new FibreOpticCable());
			firstFibreOpticCable.setAllocation(member.getEmployeeId());
			firstFibreOpticCable.setProjectTeam(projectTeam.getProjectName());
			fibreOpticCableRepository.save(firstFibreOpticCable);
			allocatedFibreOpticCables.add(firstFibreOpticCable);
			
			Laptop firstLaptop=freeStock.getLaptops().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new Laptop());
			firstLaptop.setAllocation(member.getEmployeeId());
			firstLaptop.setProjectTeam(projectTeam.getProjectName());
			laptopRepository.save(firstLaptop);
			allocatedLaptops.add(firstLaptop);
			
			Modem firstModem=freeStock.getModems().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new Modem());
			firstModem.setAllocation(member.getEmployeeId());
			firstModem.setProjectTeam(projectTeam.getProjectName());
			modemRepository.save(firstModem);
			allocatedModems.add(firstModem);
			
			Transivers firstTransivers=freeStock.getTransivers().stream().filter( con -> con.getAllocation().equals("notallocated")).findFirst().orElse(new Transivers());
			firstTransivers.setAllocation(member.getEmployeeId());
			firstTransivers.setProjectTeam(projectTeam.getProjectName());
			transiversRepository.save(firstTransivers);
			allocatedTransivers.add(firstTransivers);
		}
		freeStock.setConnectors(allocatedConnectors);
		freeStock.setEthernetCables(allocatedEthernetCables);
		freeStock.setFibreOpticCables(allocatedFibreOpticCables);
		freeStock.setLaptops(allocatedLaptops);
		freeStock.setModems(allocatedModems);
		freeStock.setTransivers(allocatedTransivers);
		freeStock.setProjectTeam(projectTeam.getProjectName());
		//System.out.println(freeStock);
		return freeStock;
	}

	@Override
	public Stock stockAvailable() {
		Stock freeStock=new Stock();
		freeStock.setLaptops(laptopRepository.findByAllocation("notallocated"));
		freeStock.setConnectors(connectorsRepository.findByAllocation("notallocated"));
		freeStock.setEthernetCables(ethernetCableRepository.findByAllocation("notallocated"));
		freeStock.setFibreOpticCables(fibreOpticCableRepository.findByAllocation("notallocated"));
		freeStock.setModems(modemRepository.findByAllocation("notallocated"));
		freeStock.setTransivers(transiversRepository.findByAllocation("notallocated"));
		freeStock.setProjectTeam("All stocks");
		return freeStock;
	}

	@Override
	public List<?> availableStocks(Item item) {
		if(item.getItemName().equals(Connectors.class.getSimpleName())) {
			return connectorsRepository.findByAllocation("notallocated");
		}
		else if(item.getItemName().equals(Laptop.class.getSimpleName())) {
			return laptopRepository.findByAllocation("notallocated");

		}
		else if(item.getItemName().equals(EthernetCable.class.getSimpleName())) {
			return ethernetCableRepository.findByAllocation("notallocated");
		}
		else if(item.getItemName().equals(FibreOpticCable.class.getSimpleName())) {
			return fibreOpticCableRepository.findByAllocation("notallocated");
		}
		else if(item.getItemName().equals(Modem.class.getSimpleName())) {
			return modemRepository.findByAllocation("notallocated");
		}
		else if(item.getItemName().equals(Transivers.class.getSimpleName())) {
			return transiversRepository.findByAllocation("notallocated");
		}
		else {
			throw new RuntimeException("Enter correct input");
		}
	}

	

}
