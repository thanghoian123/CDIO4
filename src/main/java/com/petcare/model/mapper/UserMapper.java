package com.petcare.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entity.UserEntity;
import com.petcare.model.dto.UserDTO;

@Component
public class UserMapper {

	@Autowired
	RoleMapper roleMapper;
	
	public UserDTO toUserDTO(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		UserDTO tmp = new UserDTO();
		tmp.setId(userEntity.getId());
		tmp.setFullName(userEntity.getFullName());
		tmp.setIsRemember(userEntity.getIsRemember());
		tmp.setPassword(userEntity.getPassword());
		tmp.setStatus(userEntity.getStatus());
		tmp.setUserName(userEntity.getUserName());
		tmp.setRole(roleMapper.toRoleDTO(userEntity.getRoles()));
		return tmp;
	}

	public UserEntity toUserEntity(UserDTO model) {
		UserEntity tmp = new UserEntity();
		tmp.setFullName(model.getFullName());
		tmp.setIsRemember(model.getIsRemember());
		tmp.setPassword(model.getPassword());
		tmp.setStatus(model.getStatus());
		tmp.setUserName(model.getUserName());
		return tmp;
	}

	public UserEntity toUserEntity(UserDTO model, UserEntity oldUserEntity) {
		oldUserEntity.setFullName(model.getFullName());
		oldUserEntity.setIsRemember(model.getIsRemember());
		oldUserEntity.setPassword(model.getPassword());
		oldUserEntity.setStatus(model.getStatus());
		oldUserEntity.setUserName(model.getUserName());
		return oldUserEntity;
	}
}