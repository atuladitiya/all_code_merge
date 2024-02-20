package com.mapping.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="jpa_student")
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentBranch;
    @OneToOne(mappedBy="student",cascade=CascadeType.ALL)
	private Laptop laptop;
    @OneToMany(mappedBy="student")
    private List<Address> list;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentBranch() {
		return studentBranch;
	}
	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentBranch=" + studentBranch
				+ ", laptop=" + laptop + ", list=" + list + "]";
	}
	public Student(int studentId, String studentName, String studentBranch, Laptop laptop, List<Address> list) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBranch = studentBranch;
		this.laptop = laptop;
		this.list = list;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}