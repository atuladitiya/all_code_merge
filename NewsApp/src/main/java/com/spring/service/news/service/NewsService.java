package com.spring.service.news.service;

import java.util.List;

import com.spring.service.news.entity.News;

public interface NewsService {

	public News save(News news);
	public List<News> getall();
	public News getById(int newsId) throws Exception;
    public String deleteById(int newsId);
    public News updateById(int newsId, News news) throws Exception;
}
