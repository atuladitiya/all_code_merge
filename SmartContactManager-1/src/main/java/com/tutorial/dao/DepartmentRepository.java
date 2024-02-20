package com.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tutorial.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
public Department findBydepartmentName(String departmentName);
}
