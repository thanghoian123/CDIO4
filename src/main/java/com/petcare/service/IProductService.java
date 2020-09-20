package com.petcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.model.dto.ProductDTO;

@Service
public interface IProductService {
	List<ProductDTO> getListProduct();
	List<ProductDTO> getListProductByCategoryCode(String code);
	ProductDTO save(ProductDTO model);
	void delete(long[] ids);
	ProductDTO getProductByID(Long id);
}