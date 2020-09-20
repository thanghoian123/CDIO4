package com.petcare.service;

import org.springframework.stereotype.Service;

import com.petcare.model.dto.UserDTO;

@Service
public interface IUserService {
	UserDTO checkLogin(UserDTO model);
	Boolean isExistUserName(String userName);
	UserDTO save(UserDTO model);
}