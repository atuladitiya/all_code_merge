package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeAlreadyExistsException;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		Optional<Employee> opt= repo.findById(employee.getEmpId());
		if(opt.isPresent()) {
			throw new EmployeeAlreadyExistsException("Employee Already Exists"); 
		}
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeNotFoundException {
		List<Employee> list= repo.findAll();
		if(list.isEmpty()) {
			throw new EmployeeNotFoundException("No Employee List Found");
		}
		return list;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> getById= repo.findById(empId);
		if(!getById.isPresent()){
			throw new EmployeeNotFoundException("Employee Not Found with the given id");
		}
		return getById.get();
	}

	@Override
	public Employee updateEmployeeById(int empId, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = repo.findById(empId);

	    if (!optionalEmployee.isPresent()) {
	        throw new EmployeeNotFoundException("Employee Not Found With the given id");
	    }

	    Employee found = optionalEmployee.get();

	    // Update the fields
	    found.setEmpName(employee.getEmpName());
	    found.setEmpDepartment(employee.getEmpDepartment());
	    found.setEmpDesignation(employee.getEmpDesignation());
	    found.setEmpExperience(employee.getEmpExperience());
	    found.setEmpAge(employee.getEmpAge());

	    return repo.save(found);
	}

	@Override
	public String deleteById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> emprecord= repo.findById(empId);
		if(!emprecord.isPresent()) {
			throw new EmployeeNotFoundException("No Employee Found with the given id");
		}
		repo.deleteById(empId);
		return "Employee with id:"+empId + "Successfully Deleted";	
		
	}

}
