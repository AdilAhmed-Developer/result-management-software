package com.management.rms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	@Column(name = "examName" , nullable = false)
     private String examName;
	@Column(name = "examDate" )
     private String examDate;
	@Column(name = "examSem" )
     private String examSem;
	@Column(name = "examBranch" )
    private String examBranch;
	@Column(name = "minMarks" )
    private String minMarks;
	@Column(name = "maxMarks" )
    private String maxMarks;
     
     public Exam() {
    	 
     }

	public Exam(Long id, String examName, String examDate, String examSem, String examBranch, String minMarks,
			String maxMarks) {
		super();
		this.id = id;
		this.examName = examName;
		this.examDate = examDate;
		this.examSem = examSem;
		this.examBranch = examBranch;
		this.minMarks = minMarks;
		this.maxMarks = maxMarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamSem() {
		return examSem;
	}

	public void setExamSem(String examSem) {
		this.examSem = examSem;
	}

	public String getExamBranch() {
		return examBranch;
	}

	public void setExamBranch(String examBranch) {
		this.examBranch = examBranch;
	}

	public String getMinMarks() {
		return minMarks;
	}

	public void setMinMarks(String minMarks) {
		this.minMarks = minMarks;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	

}
