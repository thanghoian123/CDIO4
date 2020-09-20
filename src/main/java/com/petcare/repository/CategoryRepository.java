package com.petcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
	List<CategoryEntity> findByCategoryID(Long i);
	
}