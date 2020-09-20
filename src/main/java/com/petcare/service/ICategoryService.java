package com.petcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.model.dto.CategoryDTO;

@Service
public interface ICategoryService {
	List<CategoryDTO> getListCategory();
	List<String> getListCategoryName();
}
