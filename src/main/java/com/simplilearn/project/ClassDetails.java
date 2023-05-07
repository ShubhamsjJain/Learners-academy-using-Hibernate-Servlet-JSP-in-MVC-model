package com.simplilearn.project;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class ClassDetails {
	
	@Id             
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="class_name")
	private String name;
	
	@OneToMany(mappedBy = "classdetails", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="student_id")
	private List<Student> stu = new ArrayList<>();

	public ClassDetails() {
		
	}

	public ClassDetails(int iD, String name, List<Student> stu) {
		
		ID = iD;
		this.name = name;
		this.stu = stu;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStu() {
		return stu;
	}

	public void setStu(List<Student> stu) {
		this.stu = stu;
	}

	
}
