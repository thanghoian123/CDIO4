package com.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.model.dto.CategoryDTO;
import com.petcare.service.ICategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private	ICategoryService categoryService;
	
	@GetMapping("/categorys")
	public ResponseEntity<?> getListCategory(){
		List<CategoryDTO> categorys = categoryService.getListCategory();
		return ResponseEntity.ok(categorys);
	}
	
	@GetMapping("/categorysName")
	public ResponseEntity<?> getListCategoryName(){
		List<String> categorys = categoryService.getListCategoryName();
		return ResponseEntity.ok(categorys);
	}
	
	@PostMapping("/categorys")
	public ResponseEntity<?> createCategory(){
		return null;
	}
	
	@PutMapping("/categorys/{id}")
	public ResponseEntity<?> updateCategory(){
		return null;
	}
	
	@DeleteMapping("/categorys/{id}")
	public ResponseEntity<?> deleteCategory(){
		return null;
	}
}