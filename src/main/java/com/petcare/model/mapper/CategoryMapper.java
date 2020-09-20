package com.petcare.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.petcare.entity.CategoryEntity;
import com.petcare.model.dto.CategoryDTO;

@Component
public class CategoryMapper {
	public CategoryDTO toCategoryDTO(CategoryEntity category) {
		CategoryDTO tmp = new CategoryDTO();
		tmp.setId(category.getId());
		tmp.setCode(category.getCode());
		tmp.setName(category.getName());
		tmp.setIsToggle(category.getIsToggle());
		return tmp;
	}
	
	public List<CategoryDTO> toCategoryDTO(List<CategoryEntity> categorys) {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		for (CategoryEntity category : categorys) {
			CategoryDTO tmp = new CategoryDTO();
			tmp.setCode(category.getCode());
			tmp.setName(category.getName());
			tmp.setIsToggle(category.getIsToggle());
			result.add(tmp);
		}
		
		
		return result;
	}
}