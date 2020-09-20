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

import com.petcare.model.dto.NewsDTO;
import com.petcare.service.INewsService;

@RestController
@RequestMapping("/api")
public class NewsController {

	@Autowired
	private INewsService newsService;

	@GetMapping("/news")
	public ResponseEntity<?> getListNews() {
		List<NewsDTO> news = newsService.getListNews();
		return ResponseEntity.ok(news);
	}
	
	@GetMapping("/news={id}")
	public ResponseEntity<?> getByNewsId(@PathVariable("id") long id) {
		NewsDTO news = newsService.getById(id);
		return ResponseEntity.ok(news);
	}
	
	@PostMapping("/news")
	public ResponseEntity<?> createNews(@RequestBody NewsDTO model) {
		NewsDTO newsDto = newsService.save(model);
		return ResponseEntity.ok(newsDto);
	}

	@PutMapping("/news/{id}")
	public ResponseEntity<?> updateNews(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		NewsDTO newsDto = newsService.save(model);
		return ResponseEntity.ok(newsDto);
	}

	@DeleteMapping("/news")
	public ResponseEntity<?> deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
		return ResponseEntity.ok("Success");
	}
}