package com.management.rms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	@Column(name = "full_name" , nullable = false)
     private String fullName;
	@Column(name = "branch" )
    private String branch;
	@Column(name = "semester" )
     private String semester;
	@Column(name = "enroll_no")
    private String enrollNo;
     
     public Student() {
    	 
     }

	public Student(Long id, String fullName, String branch, String semester, String enrollNo) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.branch = branch;
		this.semester = semester;
		this.enrollNo = enrollNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(String enrollNo) {
		this.enrollNo = enrollNo;
	}
       

     
     
}
