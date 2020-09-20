package com.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.model.dto.ProductDTO;
import com.petcare.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public ResponseEntity<?> getListProduct() {
		List<ProductDTO> products = productService.getListProduct();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{code}")
	public ResponseEntity<?> getListProductByCategory(@PathVariable("code") String code) {
		List<ProductDTO> products = productService.getListProductByCategoryCode(code);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products={id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String id) {
		ProductDTO product = productService.getProductByID(Long.parseLong(id));
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> createProduct(@RequestBody ProductDTO model) {
		ProductDTO productDto = productService.save(model);
		return ResponseEntity.ok(productDto);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody ProductDTO model, @PathVariable("id") long id) {
		model.setId(id);
		ProductDTO productDto = productService.save(model);
		return ResponseEntity.ok(productDto);
	}

	@DeleteMapping("/products")
	public ResponseEntity<?> deleteProduct(@RequestBody long[] ids) {
		productService.delete(ids);
		return ResponseEntity.ok("Success");
	}
}