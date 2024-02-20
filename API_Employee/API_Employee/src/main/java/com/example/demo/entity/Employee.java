package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="employee_table")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int empId;

@NotBlank(message="Employee name should not be blank")
private String empName;
@Positive(message = "Value must be positive")
@Min(value = 23, message = "Value must be at least 23")
@NotNull(message="Employee Age cannot be null")
private int empAge;
@NotBlank(message="Employee Department should not be blank")
private String empDepartment;
@NotBlank(message="Employee Designation should not be blank")
private String empDesignation;
@PositiveOrZero(message="The employee experience must be 0 or greater than zero")
@NotNull(message = "Field must not be null")
private int empExperience;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public int getEmpAge() {
	return empAge;
}
public void setEmpAge(int empAge) {
	this.empAge = empAge;
}
public String getEmpDepartment() {
	return empDepartment;
}
public void setEmpDepartment(String empDepartment) {
	this.empDepartment = empDepartment;
}
public String getEmpDesignation() {
	return empDesignation;
}
public void setEmpDesignation(String empDesignation) {
	this.empDesignation = empDesignation;
}
public int getEmpExperience() {
	return empExperience;
}
public void setEmpExperience(int empExperience) {
	this.empExperience = empExperience;
}
public Employee(int empId, String empName, int empAge, String empDepartment, String empDesignation,
		int empExperience) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empAge = empAge;
	this.empDepartment = empDepartment;
	this.empDesignation = empDesignation;
	this.empExperience = empExperience;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empDepartment="
			+ empDepartment + ", empDesignation=" + empDesignation + ", empExperience=" + empExperience + "]";
}



}
