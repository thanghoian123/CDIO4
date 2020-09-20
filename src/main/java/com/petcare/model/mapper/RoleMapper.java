package com.petcare.model.mapper;

import org.springframework.stereotype.Component;

import com.petcare.entity.RoleEntity;
import com.petcare.model.dto.RoleDTO;

@Component
public class RoleMapper {
	public RoleDTO toRoleDTO(RoleEntity entity) {
		RoleDTO tmp = new RoleDTO();
		tmp.setName(entity.getName());
		return tmp;
	}
}