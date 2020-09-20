
package com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByName(String name);

}