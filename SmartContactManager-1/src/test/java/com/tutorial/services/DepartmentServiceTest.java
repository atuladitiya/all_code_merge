package com.tutorial.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tutorial.dao.DepartmentRepository;
import com.tutorial.entity.Department;
@SpringBootTest
class DepartmentServiceTest {
@Autowired
private departmentService service;
@MockBean
private DepartmentRepository repo;
	@BeforeEach
	void setUp() {
		Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("IT");
        department.setDepartmentCode("IT-123");
        department.setDepartmentBranch("Head Office");
        Mockito.when(repo.findBydepartmentName("IT")).thenReturn(department);
	}
@Test
@DisplayName("Get data based on valid department name")
public void whenValidDepartmentName_then_DepartmentShouldFound() {
	String departmentName= "IT";
	Department found= service.getByDepartmentName(departmentName);
	assertEquals(departmentName,found.getDepartmentName());
}
	
}
