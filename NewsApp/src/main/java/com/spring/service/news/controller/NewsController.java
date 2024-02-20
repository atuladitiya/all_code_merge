package com.spring.service.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.news.entity.News;
import com.spring.service.news.service.NewsServiceImpl;

@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsServiceImpl impl;
	@PostMapping("/save")
    public ResponseEntity<News> saveNews(@RequestBody News news) {
        try {
            News savedNews = impl.save(news);
            return new ResponseEntity<>(savedNews, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions, e.g., log the error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/get")
	public List<News> getAllNews(){
		return impl.getall();	}

}
