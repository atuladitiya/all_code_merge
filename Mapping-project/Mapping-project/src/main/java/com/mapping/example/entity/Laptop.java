package com.mapping.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="jpa_laptop")
public class Laptop {
	@Id
	private int laptopId;
	private String laptopBrand;
	private String laptopModel;
	@OneToOne
	@JoinColumn(name="student_id")
	private Student student;
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopBrand() {
		return laptopBrand;
	}
	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}
	public String getLaptopModel() {
		return laptopModel;
	}
	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Laptop(int laptopId, String laptopBrand, String laptopModel, Student student) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.laptopModel = laptopModel;
		this.student = student;
	}
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopBrand=" + laptopBrand + ", laptopModel=" + laptopModel
				+ ", student=" + student + "]";
	}
	
	
	

}
