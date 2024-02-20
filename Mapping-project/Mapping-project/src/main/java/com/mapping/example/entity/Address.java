package com.mapping.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jpa_address")
public class Address {
	@Id
	private int addressId;
	private String street;
	private String city;
	private String road;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", road=" + road
				+ ", student=" + student + "]";
	}
	public Address(int addressId, String street, String city, String road, Student student) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.road = road;
		this.student = student;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
