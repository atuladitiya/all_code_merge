package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeAlreadyExistsException;
import com.example.demo.error.EmployeeNotFoundException;

//@Service
public interface EmployeeService {
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException;
	public List<Employee> getAllEmployee() throws EmployeeNotFoundException;
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException;
	public Employee updateEmployeeById(int empId,Employee employee) throws  EmployeeNotFoundException;
	public String deleteById(int empId) throws EmployeeNotFoundException;

}
