package com.petcare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entity.CategoryEntity;
import com.petcare.model.dto.CategoryDTO;
import com.petcare.model.mapper.CategoryMapper;
import com.petcare.repository.CategoryRepository;
import com.petcare.service.ICategoryService;

@Component
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDTO> getListCategory() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> categorys = categoryRepository.findByCategoryID((long) 0);
		for (CategoryEntity category : categorys) {
			CategoryDTO dto = categoryMapper.toCategoryDTO(category);
			List<CategoryDTO> tmp = categoryMapper.toCategoryDTO(categoryRepository.findByCategoryID(category.getId()));
			List<Object> objects = new ArrayList<Object>();
			for (CategoryDTO catedto : tmp) {
				CategoryTmp objectTmp = new CategoryTmp();
				objectTmp.setCode(catedto.getCode());
				objectTmp.setName(catedto.getName());
				
				objects.add(objectTmp);
			}
			dto.setChild(objects);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<String> getListCategoryName() {
		List<String> result = new ArrayList<String>();
		List<CategoryEntity> categoryParents = categoryRepository.findAll();
		for (CategoryEntity category : categoryParents) {
			result.add(category.getName());
		}
		return result;
	}
}

class CategoryTmp{
	String code, name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}