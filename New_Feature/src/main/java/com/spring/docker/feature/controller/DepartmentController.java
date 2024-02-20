package com.spring.docker.feature.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.docker.feature.entity.Department;
import com.spring.docker.feature.error.DepartmentNotFoundException;
import com.spring.docker.feature.service.departmentService;



@RestController
@RequestMapping("/department")
public class DepartmentController {
@Autowired
private departmentService departmentservice;
private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

@PostMapping("/save")
public ResponseEntity<Department> save(@RequestBody Department department) {
	LOGGER.info("Inside save department");
	
	Department savedDepartment= departmentservice.saveDepartment(department);
	return new ResponseEntity<>(savedDepartment,HttpStatus.OK);
}
@GetMapping("/get")
public ResponseEntity<List<Department>>getAllDepartment(){
	LOGGER.info("Inside get department");
	List getAllList=departmentservice.getAllDepartment();
	return new ResponseEntity<>(getAllList,HttpStatus.FOUND);
	   
}
@GetMapping("/getById/{id}")
public ResponseEntity<Department> fetchDepartmentById(@PathVariable ("id") Long departmentId) throws DepartmentNotFoundException {
	
	Department got= departmentservice.getDepartmentById(departmentId);
	return new ResponseEntity<>(got,HttpStatus.FOUND);
}
@DeleteMapping("/delete/{id}")
public String deleteById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
	
	 departmentservice.deleteById(departmentId);	
	 return "Id Deleted Successfully";
	
}
@PutMapping("update/{id}")
public ResponseEntity<Department> updateDepartmentById(@PathVariable ("id") Long departmentId, @RequestBody Department department) {
	Department updatedDepartment= departmentservice.updateById(departmentId,department);
	return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
	
}
@GetMapping("/department/name/{departmentName}")
public ResponseEntity<Department> fetchDepartmentByName(@PathVariable ("departmentName") String departmentName) {
	Department byusername= departmentservice.getByDepartmentName(departmentName);
	return new ResponseEntity<>(byusername,HttpStatus.FOUND);
}

}
