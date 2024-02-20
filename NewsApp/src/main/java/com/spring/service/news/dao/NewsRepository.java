package com.spring.service.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.service.news.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {

}
