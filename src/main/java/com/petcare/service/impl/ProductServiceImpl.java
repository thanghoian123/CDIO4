package com.petcare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entity.CategoryEntity;
import com.petcare.entity.ProductEntity;
import com.petcare.model.dto.ProductDTO;
import com.petcare.model.mapper.ProductMapper;
import com.petcare.repository.CategoryRepository;
import com.petcare.repository.ProductRepository;
import com.petcare.service.IProductService;

@Component
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRespository;

	@Autowired
	private CategoryRepository categoryRespository;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDTO> getListProduct() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		List<ProductEntity> products = productRespository.findAll();
		for (ProductEntity product : products) {
			result.add(productMapper.toProductDTO(product));
		}
		return result;
	}

	@Override
	public List<ProductDTO> getListProductByCategoryCode(String code) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		List<ProductEntity> products = productRespository.findAll();
		for (ProductEntity product : products) {
			if (product.getCategory().getCode().equals(code)) {
				result.add(productMapper.toProductDTO(product));
			}
		}
		return result;
	}

	@Override
	public ProductDTO save(ProductDTO model) {
		ProductEntity pEntity = new ProductEntity();
		if (model.getId() != null) {
			ProductEntity oldEntity = productRespository.findOne(model.getId());
			pEntity = productMapper.toProductEntity(model, oldEntity);
		} else {
			pEntity = productMapper.toProductEntity(model);
		}
		CategoryEntity categoryEntity = categoryRespository.findOneByCode(model.getCategoryCode());
		pEntity.setCategory(categoryEntity);
		pEntity = productRespository.save(pEntity);
		return productMapper.toProductDTO(pEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			productRespository.delete(id);
		}
	}

	@Override
	public ProductDTO getProductByID(Long id) {
		return productMapper.toProductDTO(productRespository.findOne(id));
	}


}