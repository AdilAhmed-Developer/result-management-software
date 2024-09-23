package com.management.rms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	@Column(name = "subjectName" , nullable = false)
     private String subjectName;
	@Column(name = "semester" )
     private String semester;
	@Column(name = "branch" )
     private String branch;
	@Column(name = "allocatedTeacher" )
    private String allocatedTeacher;
	@Column(name = "type" )
    private String type;
     
     public Subject() {
    	 
     }

	public Subject(Long id, String subjectName, String semester, String branch, String allocatedTeacher, String type) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.semester = semester;
		this.branch = branch;
		this.allocatedTeacher = allocatedTeacher;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAllocatedTeacher() {
		return allocatedTeacher;
	}

	public void setAllocatedTeacher(String allocatedTeacher) {
		this.allocatedTeacher = allocatedTeacher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
     
     

}