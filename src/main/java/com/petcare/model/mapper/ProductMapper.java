package com.petcare.model.mapper;

import org.springframework.stereotype.Component;

import com.petcare.entity.ProductEntity;
import com.petcare.model.dto.ProductDTO;

@Component
public class ProductMapper {
	public ProductEntity toProductEntity(ProductDTO dto, ProductEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setPrice(dto.getPrice());
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		
		return entity;
	}
	
	public ProductEntity toProductEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setTitle(dto.getTitle());
		entity.setPrice(dto.getPrice());
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		
		return entity;
	}
	
	public ProductDTO toProductDTO(ProductEntity product) {
		ProductDTO tmp = new ProductDTO();
		tmp.setId(product.getId());
		tmp.setTitle(product.getTitle());
		tmp.setPrice(product.getPrice());
		tmp.setDescription(product.getDescription());
		tmp.setImgUrl(product.getImgUrl());
		tmp.setCategoryCode(product.getCategory().getCode());
		return tmp;
	}
}