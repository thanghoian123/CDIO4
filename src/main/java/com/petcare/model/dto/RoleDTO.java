package com.petcare.model.dto;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDTO {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
