package com.question.example.service;

import java.util.List;

import com.question.example.entity.Question;

public interface QuestionService {
	
	public Question saveQuestion(Question question);
	public List<Question> getAllQuestion();
	public Question getQuestionById(Long questionId);
	
	public List<Question> getQuestionByQuizId(Long quizId);
}
