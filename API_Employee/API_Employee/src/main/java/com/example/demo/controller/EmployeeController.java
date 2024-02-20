package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeAlreadyExistsException;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
private EmployeeServiceImpl impl;
	
@PostMapping("/save")
public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee emp) throws EmployeeAlreadyExistsException {
	try {
	Employee savedEmployee= impl.saveEmployee(emp);
	return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
}
	catch(EmployeeAlreadyExistsException exe) {
		return new ResponseEntity<String>(exe.getMessage(),HttpStatus.CONFLICT);
	}

}

@GetMapping("/getAll")
public ResponseEntity<?> getAllEmployee() throws EmployeeNotFoundException{
	try {
		List<Employee> emplist= impl.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.FOUND);
	}
	catch(EmployeeNotFoundException exe) {
		return new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
	}
}


@GetMapping("/getById/{id}")
public ResponseEntity<?> getEmployeeById(@PathVariable("id") int employeeId) throws EmployeeNotFoundException{
	try {
		Employee found= impl.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(found,HttpStatus.FOUND);
	}
	catch(EmployeeNotFoundException exe) {
		return new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
	}
}

@PutMapping("/update/{id}")
public ResponseEntity<?> updateEmployeeById(@PathVariable("id") int empId, @RequestBody Employee employee) throws EmployeeNotFoundException{
	try {
		Employee updatedUser= impl.updateEmployeeById(empId, employee);
		return new ResponseEntity<Employee>(updatedUser,HttpStatus.OK);
	}
	catch(EmployeeNotFoundException exe) {
		return new ResponseEntity<String>(exe.getMessage(),HttpStatus.NOT_FOUND);
	}
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteById(@PathVariable("id") int empId){
	try {
		String response=this.impl.deleteById(empId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	catch(EmployeeNotFoundException exe) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exe.getMessage());
	}
}
}

