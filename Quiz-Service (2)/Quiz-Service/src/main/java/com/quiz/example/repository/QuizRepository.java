package com.quiz.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.example.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
	

}
