package com.petcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petcare.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long>{

}