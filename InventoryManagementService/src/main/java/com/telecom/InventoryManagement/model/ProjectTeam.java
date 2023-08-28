package com.telecom.InventoryManagement.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTeam {
	
	private String projectName;
	private List<employee> projectMembers;

}
