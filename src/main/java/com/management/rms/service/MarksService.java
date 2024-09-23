package com.management.rms.service;

import java.io.IOException;
import java.util.List;


import com.management.rms.entity.Marks;

import jakarta.servlet.http.HttpServletResponse;

public interface MarksService {
	
	List<Marks> getAllStudentsMarks();
	List<Marks> findByPassedStudents();
	int findByCountPassedStudents();
	
	Marks saveMarks(Marks marks);
	Marks getMarkById(Long id);
	Marks updateMark(Marks marks);
	void deleteMarkById(Long id);

	List<Marks> exportResultToExcel(HttpServletResponse response) throws IOException;
	
	
}
