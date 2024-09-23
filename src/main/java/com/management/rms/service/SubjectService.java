package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;
import com.management.rms.entity.Teacher;

public interface SubjectService {
	
	List<Subject> getAllSubjects();
	List<Teacher> getAllTeachers();
	List<Subject> findSubjectsByKeyword(String branch,String semester);
	
	Subject saveSubject(Subject subject);
	Subject getSubjectById(Long id);
	Subject updateSubject(Subject subject);
	void deleteSubjectById(Long id);
}
