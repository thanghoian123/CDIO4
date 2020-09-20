package com.petcare.model.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDTO {
	private Long id;
	private String name;
	private String code;
	private List<Object> child;
	private String isToggle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Object> getChild() {
		return child;
	}

	public void setChild(List<Object> child) {
		this.child = child;
	}

	public String getIsToggle() {
		return isToggle;
	}

	public void setIsToggle(String isToggle) {
		this.isToggle = isToggle;
	}

}