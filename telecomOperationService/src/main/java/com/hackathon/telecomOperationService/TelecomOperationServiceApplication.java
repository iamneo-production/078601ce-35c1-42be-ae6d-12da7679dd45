package com.hackathon.telecomOperationService;

import com.hackathon.telecomOperationService.entities.Resources;
import com.hackathon.telecomOperationService.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TelecomOperationServiceApplication implements CommandLineRunner {

	@Autowired
	private ResourceRepo resourceRepo;


	public static void main(String[] args) {

		SpringApplication.run(TelecomOperationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Resources r1 = new Resources();
//		r1.setResourceName("Mouse");
//		r1.setResourceAllocationStatus(false);
//		resourceRepo.save(r1);
//		Resources r2 = new Resources();
//		r2.setResourceName("Cable");
//		r2.setResourceAllocationStatus(false);
//		resourceRepo.save(r2);
//
//		Resources r3 = new Resources();
//		r3.setResourceName("Monitor");
//		r3.setResourceAllocationStatus(false);
//		resourceRepo.save(r3);
//
//		Resources r4 = new Resources();
//		r4.setResourceName("Headset");
//		r4.setResourceAllocationStatus(false);
//		resourceRepo.save(r4);

	}
}
