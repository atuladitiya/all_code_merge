package com.quiz.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.example.entity.Quiz;
import com.quiz.example.service.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizServiceImpl impl;
	@PostMapping("/save")
	public Quiz saveQuiz(@RequestBody Quiz quiz) {
		return impl.saveQuiz(quiz);
	}
	@GetMapping("/getAll")
	public List<Quiz> getAllQuiz(){
		return impl.getAllQuiz();
	}
	
	@GetMapping("/getById/{id}")
	public Quiz getById(@PathVariable("id") Long id) {
		return impl.getById(id);
	}

}
