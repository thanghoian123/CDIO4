package com.petcare.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.petcare.entity.NewsEntity;
import com.petcare.model.dto.NewsDTO;

@Component
public class NewsMapper {
	public NewsDTO toNewsDTO(NewsEntity news) {
		NewsDTO tmp = new NewsDTO();
		tmp.setId(news.getId());
		tmp.setContent(news.getContent());
		tmp.setImgUrl(news.getImgUrl());
		tmp.setTitle(news.getTitle());
		tmp.setShortDescription(news.getShortDescription());
		return tmp;
	}
	
	public List<NewsDTO> toNewsDTO(List<NewsEntity> newsS) {
		List<NewsDTO> result = new ArrayList<NewsDTO>();
		for (NewsEntity news : newsS) {
			NewsDTO tmp = new NewsDTO();
			tmp.setId(news.getId());
			tmp.setContent(news.getContent());
			tmp.setImgUrl(news.getImgUrl());
			tmp.setTitle(news.getTitle());
			tmp.setShortDescription(news.getShortDescription());
			result.add(tmp);
		}

		return result;
	}
	
	public NewsEntity toNewsEntity(NewsDTO news) {
		NewsEntity tmp = new NewsEntity();
		tmp.setContent(news.getContent());
		tmp.setImgUrl(news.getImgUrl());
		tmp.setShortDescription(news.getShortDescription());
		tmp.setTitle(news.getTitle());
		return tmp;
	}
	
	public NewsEntity toNewsEntity(NewsDTO dto, NewsEntity entity) {
		entity.setContent(dto.getContent());
		entity.setImgUrl(dto.getImgUrl());
		entity.setShortDescription(dto.getShortDescription());
		entity.setTitle(dto.getTitle());
		return entity;
	}
}