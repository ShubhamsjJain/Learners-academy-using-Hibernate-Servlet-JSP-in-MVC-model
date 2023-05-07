package com.simplilearn.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id             
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="e_Mail")
	private String e_mail;
	
	@Column(name="City")
	private String city;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassDetails classdetails;

	public Student() {
		
	}

	public Student(int iD, String name, String e_mail, String city, ClassDetails classdetails) {
		
		ID = iD;
		this.name = name;
		this.e_mail = e_mail;
		this.city = city;
		this.classdetails = classdetails;
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

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ClassDetails getClassdetails() {
		return classdetails;
	}

	public void setClassdetails(ClassDetails classdetails) {
		this.classdetails = classdetails;
	}
	
	
	
	
	

}
