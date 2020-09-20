package com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petcare.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndPassword(String username, String password);
	UserEntity findOneByUserName(String username);
}
