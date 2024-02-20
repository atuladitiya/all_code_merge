package com.tutorial.services;

import java.util.List;

import com.tutorial.Error.DepartmentNotFoundException;
import com.tutorial.entity.Department;

public interface departmentService {
public Department saveDepartment(Department department);

public List<Department> getAllDepartment();

public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

public void deleteById(Long departmentId);



public Department updateById(Long departmentId, Department department);

public Department getByDepartmentName(String departmentName); 
}

