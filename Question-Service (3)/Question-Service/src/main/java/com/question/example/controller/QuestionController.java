package com.question.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.example.entity.Question;
import com.question.example.service.QuestionServiceImpl;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	private QuestionServiceImpl impl;
	@PostMapping("/save")
	public Question saveQuestion(@RequestBody Question question) {
		return impl.saveQuestion(question);
	}
	@GetMapping("/getAll")
	public List<Question> getAllQuestions(){
		return impl.getAllQuestion();
		
	}
	@GetMapping("/getById/{questionId}")
	public Question getQuestionById(@PathVariable("questionId") Long questionId) {
		return impl.getQuestionById(questionId);
	}
	
	@GetMapping("/getByQuizId/{quizId}")
	public List<Question> getQuestionsByQuizId(@PathVariable("quizId") Long quizId){
		return impl.getQuestionByQuizId(quizId);
	}

}
