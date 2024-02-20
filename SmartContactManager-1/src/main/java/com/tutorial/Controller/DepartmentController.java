package com.tutorial.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.Error.DepartmentNotFoundException;
import com.tutorial.entity.Department;
import com.tutorial.services.departmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
@Autowired
private departmentService departmentservice;
private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

@PostMapping("/save")
public Department save(@RequestBody Department department) {
	LOGGER.info("Inside save department");
	return departmentservice.saveDepartment(department); 
}
@GetMapping("/get")
public List<Department> getAllDepartment(){
	LOGGER.info("Inside get department");
	return departmentservice.getAllDepartment(); 
	   
}
@GetMapping("/getById/{id}")
public Department fetchDepartmentById(@PathVariable ("id") Long departmentId) throws DepartmentNotFoundException {
	
	return departmentservice.getDepartmentById(departmentId); 
}
@DeleteMapping("/delete/{id}")
public String deleteById(@PathVariable("id") Long departmentId) {
	
	 departmentservice.deleteById(departmentId);
	 return "Id Deleted Successfully";
	
}
@PutMapping("update/{id}")
public Department updateDepartmentById(@PathVariable ("id") Long departmentId, @RequestBody Department department) {
	return departmentservice.updateById(departmentId,department);
	
}
@GetMapping("/department/name/{name}")
public Department fetchDepartmentByName(@PathVariable ("name") String departmentName) {
	return departmentservice.getByDepartmentName(departmentName);
}

}
