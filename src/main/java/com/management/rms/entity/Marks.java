package com.management.rms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	
	@Column(name = "student_name")
    private String studentName;
	@Column(name = "exam_name" )
     private String examName;
	@Column(name = "branch" )
    private String branch;
	@Column(name = "semester" )
     private String semester;
	
	@Column(name = "subjectMinMarks" )
    private String subjectMinMarks;
	@Column(name = "subjectMaxMarks" )
    private String subjectMaxMarks;
	
	
	@Column(name = "subject1" )
    private String subject1;
	@Column(name = "subject1ObtainedMarks" )
    private String subject1ObtainedMarks;
	
	@Column(name = "subject2" )
    private String subject2;
	@Column(name = "subject2ObtainedMarks" )
    private String subject2ObtainedMarks;
	
	
	@Column(name = "subject3" )
    private String subject3;
	@Column(name = "subject3ObtainedMarks" )
    private String subject3ObtainedMarks;
	
	
	@Column(name = "subject4" )
    private String subject4;
	@Column(name = "subject4ObtainedMarks" )
    private String subject4ObtainedMarks;
	
	
	@Column(name = "subject5" )
    private String subject5;
	@Column(name = "subject5ObtainedMarks" )
    private String subject5ObtainedMarks;

	
	@Column(name = "percentage" )
    private float percentage;
	@Column(name = "result" )
     private String result;
	
	
     public Marks() {
    	 
     }






	public Marks(Long id, String studentName, String examName, String branch, String semester, String subjectMinMarks,
		String subjectMaxMarks, String subject1, String subject1ObtainedMarks, String subject2,
		String subject2ObtainedMarks, String subject3, String subject3ObtainedMarks, String subject4,
		String subject4ObtainedMarks, String subject5, String subject5ObtainedMarks,float percentage,String result) {
	super();
	this.id = id;
	this.studentName = studentName;
	this.examName = examName;
	this.branch = branch;
	this.semester = semester;
	this.subjectMinMarks = subjectMinMarks;
	this.subjectMaxMarks = subjectMaxMarks;
	this.subject1 = subject1;
	this.subject1ObtainedMarks = subject1ObtainedMarks;
	this.subject2 = subject2;
	this.subject2ObtainedMarks = subject2ObtainedMarks;
	this.subject3 = subject3;
	this.subject3ObtainedMarks = subject3ObtainedMarks;
	this.subject4 = subject4;
	this.subject4ObtainedMarks = subject4ObtainedMarks;
	this.subject5 = subject5;
	this.subject5ObtainedMarks = subject5ObtainedMarks;
	this.percentage = percentage;
	this.result = result;
}



	


	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getStudentName() {
		return studentName;
	}






	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}






	public String getExamName() {
		return examName;
	}






	public void setExamName(String examName) {
		this.examName = examName;
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






	public String getSubjectMinMarks() {
		return subjectMinMarks;
	}






	public void setSubjectMinMarks(String subjectMinMarks) {
		this.subjectMinMarks = subjectMinMarks;
	}






	public String getSubjectMaxMarks() {
		return subjectMaxMarks;
	}






	public void setSubjectMaxMarks(String subjectMaxMarks) {
		this.subjectMaxMarks = subjectMaxMarks;
	}






	public String getSubject1() {
		return subject1;
	}






	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}






	public String getSubject1ObtainedMarks() {
		return subject1ObtainedMarks;
	}






	public void setSubject1ObtainedMarks(String subject1ObtainedMarks) {
		this.subject1ObtainedMarks = subject1ObtainedMarks;
	}






	public String getSubject2() {
		return subject2;
	}






	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}






	public String getSubject2ObtainedMarks() {
		return subject2ObtainedMarks;
	}






	public void setSubject2ObtainedMarks(String subject2ObtainedMarks) {
		this.subject2ObtainedMarks = subject2ObtainedMarks;
	}






	public String getSubject3() {
		return subject3;
	}






	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}






	public String getSubject3ObtainedMarks() {
		return subject3ObtainedMarks;
	}






	public void setSubject3ObtainedMarks(String subject3ObtainedMarks) {
		this.subject3ObtainedMarks = subject3ObtainedMarks;
	}






	public String getSubject4() {
		return subject4;
	}






	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}






	public String getSubject4ObtainedMarks() {
		return subject4ObtainedMarks;
	}






	public void setSubject4ObtainedMarks(String subject4ObtainedMarks) {
		this.subject4ObtainedMarks = subject4ObtainedMarks;
	}






	public String getSubject5() {
		return subject5;
	}






	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}






	public String getSubject5ObtainedMarks() {
		return subject5ObtainedMarks;
	}






	public float getPercentage() {
		return percentage;
	}






	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}






	public String getResult() {
		return result;
	}






	public void setResult(String result) {
		this.result = result;
	}






	public void setSubject5ObtainedMarks(String subject5ObtainedMarks) {
		this.subject5ObtainedMarks = subject5ObtainedMarks;
	}





	@Column(name = "percentage" )
	public float percentage () {
		float total = Float.parseFloat(subject1ObtainedMarks) + Float.parseFloat(subject2ObtainedMarks) + Float.parseFloat(subject3ObtainedMarks) + Float.parseFloat(subject4ObtainedMarks) + Float.parseFloat(subject5ObtainedMarks);
		float maxTotal =  Float.parseFloat(subjectMaxMarks) * 5;
		float final_percent = (total * 100)/maxTotal;
		return final_percent;
	}
	





	@Column(name = "result" )
	public Boolean status() {
		float total = Float.parseFloat(subject1ObtainedMarks) + Float.parseFloat(subject2ObtainedMarks) + Float.parseFloat(subject3ObtainedMarks) + Float.parseFloat(subject4ObtainedMarks) + Float.parseFloat(subject5ObtainedMarks);
		float maxTotal =  Float.parseFloat(subjectMaxMarks) * 5;
		float final_percent = (total * 100)/maxTotal;
		if(final_percent > 35.0f) {
			return true;
		}else {
			return false;
		}
		
	}

	
     
}
