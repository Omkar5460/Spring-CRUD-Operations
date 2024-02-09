package com.springcrud.SpringCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="information")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollno;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="city")
	private String City;
	
	public StudentInfo() {
		
	}
	

	public StudentInfo(int rollno, String name, String city) {
		super();
		this.rollno = rollno;
		Name = name;
		City = city;
	}

	
	public int getrollno() {
		return rollno;
	}

	public void setrollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	

}
