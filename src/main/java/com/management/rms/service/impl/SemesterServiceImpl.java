package com.management.rms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.management.rms.entity.Semester;
import com.management.rms.repository.SemesterRepository;
import com.management.rms.service.SemesterService;


@Service
public class SemesterServiceImpl implements SemesterService{
	
	private SemesterRepository  semesterRepository;
	
	

	public SemesterServiceImpl(SemesterRepository semesterRepository) {
		super();
		this.semesterRepository = semesterRepository;
	}



	@Override
	public List<Semester> getAllSemesters() {
		return semesterRepository.findAll();
	}



	@Override
	public Semester saveSemester(Semester semester) {
		return semesterRepository.save(semester);
	}



	@Override
	public Semester getSemesterById(Long id) {
		return semesterRepository.findById(id).get();
	}



	@Override
	public Semester updateSemester(Semester semester) {
		return semesterRepository.save(semester);
	}



	@Override
	public void deleteSemesterById(Long id) {
		semesterRepository.deleteById(id);
	}

}
