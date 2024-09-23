package com.management.rms.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.management.rms.entity.Student;
import com.management.rms.repository.StudentRepository;
import com.management.rms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository  studentRepository;
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	




	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}



	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}



	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}



	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}



	@Override
	public List<Student> findStudentsByKeyword(String branch,String semester) {
		return studentRepository.findByBranchAndSemester(branch,semester);
	}
	

}
