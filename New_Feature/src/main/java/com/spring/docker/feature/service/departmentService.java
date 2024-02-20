package com.spring.docker.feature.service;

import java.util.List;

import com.spring.docker.feature.entity.Department;
import com.spring.docker.feature.error.DepartmentNotFoundException;


public interface departmentService {
public Department saveDepartment(Department department);

public List<Department> getAllDepartment();

public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

public void deleteById(Long departmentId) throws DepartmentNotFoundException;



public Department updateById(Long departmentId, Department department);

public Department getByDepartmentName(String departmentName); 
}