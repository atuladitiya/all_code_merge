package com.quiz.example.service;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.example.entity.Question;

@FeignClient(url="http://localhost:9002",value="Question-Client")
public interface QuestionClient {
	@GetMapping("/questions/getByQuizId/{quizId}")
	List<Question> getQuestionOfQuiz(@PathVariable("quizId") Long quizId);

}
