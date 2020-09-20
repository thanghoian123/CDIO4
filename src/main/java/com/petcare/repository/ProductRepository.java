package com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
