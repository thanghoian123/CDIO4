package com.petcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petcare.model.dto.NewsDTO;

@Service
public interface INewsService {
	List<NewsDTO> getListNews();
	NewsDTO save(NewsDTO model);
	void delete(long[] ids);
	NewsDTO getById(long id);
}