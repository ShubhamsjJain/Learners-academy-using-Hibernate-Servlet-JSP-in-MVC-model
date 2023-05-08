package com.simplilearn.project;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int ID;
	
	@Column(name="subject_name")
	private String s_name;
	
	@ManyToMany
	@JoinTable(
			name="classes_subject",
			joinColumns = @JoinColumn(name="subject_id"),
			inverseJoinColumns = @JoinColumn(name="class_id")
			)
	private List<ClassDetails> classes;

	public Subject() {
		
	}

	public Subject(int iD, String s_name, List<ClassDetails> classes) {
		super();
		ID = iD;
		this.s_name = s_name;
		this.classes = classes;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public List<ClassDetails> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassDetails> classes) {
		this.classes = classes;
	} 
	
	
	
}
