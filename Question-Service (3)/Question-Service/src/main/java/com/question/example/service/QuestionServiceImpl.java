package com.question.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.example.entity.Question;
import com.question.example.repository.QuestionRepository;
@Service
public class QuestionServiceImpl implements QuestionService {
@Autowired
private QuestionRepository repo;
	@Override
	public Question saveQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Question getQuestionById(Long questionId) {
		// TODO Auto-generated method stub
		return repo.findById(questionId).get();
	}

	@Override
	public List<Question> getQuestionByQuizId(Long quizId) {
		
		return repo.findByQuizId(quizId);
	}

}
