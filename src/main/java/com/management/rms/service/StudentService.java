package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	List<Student> findStudentsByKeyword(String branch,String semester);
	
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
