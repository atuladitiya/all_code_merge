package com.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="department")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long departmentId;
private String departmentName;
private String departmentCode;
private String departmentBranch;
public Long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getDepartmentCode() {
	return departmentCode;
}
public void setDepartmentCode(String departmentCode) {
	this.departmentCode = departmentCode;
}
public String getDepartmentBranch() {
	return departmentBranch;
}
public void setDepartmentBranch(String departmentBranch) {
	this.departmentBranch = departmentBranch;
}
public Department(Long departmentId, String departmentName, String departmentCode, String departmentBranch) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.departmentCode = departmentCode;
	this.departmentBranch = departmentBranch;
}
public Department() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentCode="
			+ departmentCode + ", departmentBranch=" + departmentBranch + "]";
}


}
