package com.simplilearn.project;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int ID;
	
	@Column(name= "teacher_name")
	private String name;
	
	@Column(name="teacher_email")
	private String e_mail;
	
	@Column(name= "city")
	private String City;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="teacher_subject",
			joinColumns = @JoinColumn(name="teacher_id"),
			inverseJoinColumns = @JoinColumn(name="subject_id")
			)
	private List<Subject> s_objects = new ArrayList<>(); //List of all subjects object which are taught by this teacher

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="teacher_class",
			joinColumns = @JoinColumn(name="teacher_id"),
			inverseJoinColumns = @JoinColumn(name="class_id")
			)
	private List<ClassDetails> classes = new ArrayList<>(); //List objects of all Class Entity in which this subject is assigned
	
	public Teacher() {
		
	}

	

	public Teacher(int iD, String name, String e_mail, String city, List<Subject> s_objects,
			List<ClassDetails> classes) {
		super();
		ID = iD;
		this.name = name;
		this.e_mail = e_mail;
		City = city;
		this.s_objects = s_objects;
		this.classes = classes;
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
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public List<Subject> getS_objects() {
		return s_objects;
	}

	public void setS_objects(List<Subject> s_objects) {
		this.s_objects = s_objects;
	}



	public List<ClassDetails> getClasses() {
		return classes;
	}



	public void setClasses(List<ClassDetails> classes) {
		this.classes = classes;
	}
	
	
	

	
}
