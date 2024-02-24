package com.quiz.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quiz.example.entity.Quiz;
import com.quiz.example.repository.QuizRepository;

public interface QuizService {
	
	
public Quiz saveQuiz(Quiz quiz);
public List<Quiz> getAllQuiz();
public Quiz getById(Long id);

}
