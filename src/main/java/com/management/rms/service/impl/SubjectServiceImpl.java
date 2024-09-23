package com.management.rms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;
import com.management.rms.entity.Teacher;
import com.management.rms.repository.SubjectRepository;
import com.management.rms.repository.TeacherRepository;
import com.management.rms.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	private SubjectRepository  subjectRepository;
	private TeacherRepository  teacherRepository;
	
	

	public SubjectServiceImpl(SubjectRepository subjectRepository,TeacherRepository teacherRepository) {
		super();
		this.subjectRepository = subjectRepository;
		this.teacherRepository = teacherRepository;
	}



	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}



	@Override
	public Subject saveSubject(Subject subject) {
		
		return subjectRepository.save(subject);
	}



	@Override
	public Subject getSubjectById(Long id) {
		return subjectRepository.findById(id).get();
	}



	@Override
	public Subject updateSubject(Subject subject) {
		return subjectRepository.save(subject);
	}



	@Override
	public void deleteSubjectById(Long id) {
		subjectRepository.deleteById(id);
	}



	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
		
	}
	

	@Override
	public List<Subject> findSubjectsByKeyword(String branch,String semester) {
		return subjectRepository.findByBranchAndSemester(branch,semester);
	}

}
