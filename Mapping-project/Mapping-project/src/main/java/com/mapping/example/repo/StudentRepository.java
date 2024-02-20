package com.mapping.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	

}
