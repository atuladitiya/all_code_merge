package com.spring.service.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.spring.service.news.dao.NewsRepository;
import com.spring.service.news.entity.News;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsRepository repo;

	@Override
	public News save(News news) {
		return repo.save(news);
	}

	@Override
	public List<News> getall() {
		return repo.findAll();
	}

	@Override
	public News getById(int newsId) throws Exception {
		java.util.Optional<News> news= repo.findById(newsId);
		if(!news.isPresent()) {
			throw new Exception("Department not found with"+newsId); 
		}
		return news.get();
		
	}

	@Override
	public String deleteById(int newsId) {
		java.util.Optional<News> news= repo.findById(newsId);
		if(!news.isPresent()) {
			return "No such id found";
		}
		repo.deleteById(newsId);
		return "News Deleted Successfully";
		
			}

	@Override
	public News updateById(int newsId, News news) throws Exception {
		java.util.Optional<News> newsnew= repo.findById(newsId);
		if(!newsnew.isPresent()) {
			throw new Exception("Department not found with"+newsId);
		}
		News foundNews=newsnew.get();
		foundNews.setNewsName(news.getNewsName());
		return foundNews;
	}

}
