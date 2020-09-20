package com.petcare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entity.RoleEntity;
import com.petcare.entity.UserEntity;
import com.petcare.model.dto.UserDTO;
import com.petcare.model.mapper.UserMapper;
import com.petcare.repository.RoleRepository;
import com.petcare.repository.UserRepository;
import com.petcare.service.IUserService;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMapper userMapper;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public UserDTO checkLogin(UserDTO model) {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findOneByUserNameAndPassword(model.getUserName(), model.getPassword());
		return userMapper.toUserDTO(userEntity);
	}

	@Override
	public Boolean isExistUserName(String userName) {
		return userRepository.findOneByUserName(userName) == null ? false : true;
	}

	@Override
	public UserDTO save(UserDTO model) {
		UserEntity userEntity = new UserEntity();
		if (model.getId() != null) {
			UserEntity oldUserEntity = userRepository.findOne(model.getId());
			userEntity = userMapper.toUserEntity(model, oldUserEntity);
		} else {
			userEntity = userMapper.toUserEntity(model);
		}
		RoleEntity roleEntity = roleRepository.findOneByName(model.getRole().getName());
		userEntity.setRoles(roleEntity);
		userEntity = userRepository.save(userEntity);
		return userMapper.toUserDTO(userEntity);
	}
}
