package com.petcare.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entity.NewsEntity;
import com.petcare.model.dto.NewsDTO;
import com.petcare.model.mapper.NewsMapper;
import com.petcare.repository.NewsRepository;
import com.petcare.service.INewsService;

@Component
public class NewsServiceImpl implements INewsService{

	@Autowired
	NewsRepository newsRepository;
	
	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public List<NewsDTO> getListNews() {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		result = newsMapper.toNewsDTO(newsRepository.findAll());
		return result;
	}

	@Override
	public NewsDTO save(NewsDTO model) {
		NewsEntity news = new NewsEntity();
		if (model.getId() != null) {
			NewsEntity oldNews = newsRepository.findOne(model.getId());
			news = newsMapper.toNewsEntity(model, oldNews);
		}else {
			news = newsMapper.toNewsEntity(model);
		}
		news = newsRepository.save(news);
		return newsMapper.toNewsDTO(news);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsRepository.delete(id);
		}
		
	}

	@Override
	public NewsDTO getById(long id) {
		NewsEntity result = newsRepository.findOne(id);
		return newsMapper.toNewsDTO(result);
	}

}