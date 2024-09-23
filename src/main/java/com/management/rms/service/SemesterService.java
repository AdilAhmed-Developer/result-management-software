package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Branch;
import com.management.rms.entity.Semester;


public interface SemesterService {
	
	List<Semester> getAllSemesters();
	
	Semester saveSemester(Semester semester);
	Semester getSemesterById(Long id);
	Semester updateSemester(Semester semester);
	void deleteSemesterById(Long id);
}
