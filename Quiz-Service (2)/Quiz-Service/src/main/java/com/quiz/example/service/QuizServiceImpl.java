package com.quiz.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.example.entity.Quiz;
import com.quiz.example.repository.QuizRepository;
@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository repo;
	@Autowired
	private QuestionClient client;

	@Override
	public Quiz saveQuiz(Quiz quiz) {
		return repo.save(quiz);
	} 

	@Override
	public List<Quiz> getAllQuiz() {
		List<Quiz> quiz= repo.findAll();
		
		List<Quiz> newQuizList=quiz.stream().map(e->{
		e.setQuestions(client.getQuestionOfQuiz(e.getId()));
		return e;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	@Override
	public Quiz getById(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz= repo.findById(id).get();
		quiz.setQuestions(client.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
